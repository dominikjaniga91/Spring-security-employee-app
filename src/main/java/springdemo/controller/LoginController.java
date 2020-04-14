package springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showLoginForm(){

        return "login-form";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){

        return "access-denied";
    }

}
