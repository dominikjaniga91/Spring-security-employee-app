package springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/controlPanel")
    public String showControlPanel(){
        return "controlPanel";
    }

    @GetMapping("/employee")
    public String showEmployee(){
        return "employee";
    }

    @GetMapping("/leaders")
    public String showLeadersPage(){
        return "leaders";
    }

    @GetMapping("/settings")
    public String showSettingsPage(){
        return "settings";
    }



}
