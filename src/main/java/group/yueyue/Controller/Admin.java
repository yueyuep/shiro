package group.yueyue.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by lp on 2020/6/27
 * 用户登录的
 */
@Controller
public class Admin {
    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest httpServletRequest, boolean rememberme) {
        rememberme = true;
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        usernamePasswordToken.setRememberMe(rememberme);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            System.out.println("登录成功");
            /*记录登录日志*/
            String ipAddress = httpServletRequest.getRequestURL().toString();

            System.out.println(ipAddress);

            return "index";

        } catch (AuthenticationException e) {
            System.out.println("登录失败");
            return "login";
        }


    }

    /*@RequestMapping("/tologin")
    public String toLogin() {
        return "login";
    }*/

    @RequestMapping("/user/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/user/update")
    public String update() {
        return "update";
    }

}
