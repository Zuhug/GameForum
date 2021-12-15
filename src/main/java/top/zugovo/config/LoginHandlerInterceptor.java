package top.zugovo.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 登陆拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 如果存在用户的session, 表示用户已经登陆
        Object account = request.getSession().getAttribute("loginAccount");

        // 如果用户在未登录的情况下, 想要访问/user/下面的资源, 要被拦截下来
        if ( account == null ) { // 没有登录
            // 提示信息
            request.setAttribute("msg", "没有权限, 请先登录");
            // 转发到登录页面
            request.getRequestDispatcher("/toLogin").forward(request, response);
            // 被拦截
            return false;
        }

        // 放行
        return true;
    }

}
