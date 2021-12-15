package top.zugovo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zugovo.entity.Account;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class OtherController {

    @RequestMapping("/")
    public String test(HttpServletRequest request) {
        Object account = request.getSession().getAttribute("loginAccount");
        if ( account == null ) {
            return "redirect:/index";
        }
        return "redirect:/user/success";
    }

    @RequestMapping("/user/info")
    public String test1(HttpSession session) {
        Account account = (Account) session.getAttribute("loginAccount");
        return "redirect:/user/getAllArticalsByUid/" + account.getUid() + "/1";
    }

}
