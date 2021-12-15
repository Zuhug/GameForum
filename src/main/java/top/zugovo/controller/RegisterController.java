package top.zugovo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import top.zugovo.entity.Account;
import top.zugovo.entity.User;
import top.zugovo.service.RegisterService;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService service;

    @PostMapping("/register")
    public String register(User user, Account account, @RequestParam("birthStr") String birthStr, MultipartFile imgUpload) {
        service.register(user, account, birthStr, imgUpload);
        return "redirect:/toLogin";
    }

}
