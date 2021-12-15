package top.zugovo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zugovo.entity.Account;
import top.zugovo.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    // 登录失败
    @GetMapping("/loginError")
    public void incorrectAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 提示信息
        request.setAttribute("msg", "账号或密码错误, 请重新登录!");
        // 转发到登录页面
        request.getRequestDispatcher("/toLogin").forward(request, response);
    }

    @PostMapping(value = "/login", produces = "text/html;charset=UTF-8")
    public String login(Account account, HttpSession session) {
        // 去数据库里面取出这条数据 (此时里面只有id, email, password等信息)
        Account completeAccount = service.login(account);
        if ( completeAccount != null ) { // 登录成功
            // 获得完整的Account (Account, User, Role)
            completeAccount = service.getAccount(completeAccount.getId());
            System.out.println(completeAccount);
            // 保存到session
            session.setAttribute("loginAccount", completeAccount);
            // 设置60分钟的有效时间
            session.setMaxInactiveInterval(60 * 60);
            return "redirect:/user/success";
        }
        // 登录失败
        return "redirect:/loginError";
    }

}
