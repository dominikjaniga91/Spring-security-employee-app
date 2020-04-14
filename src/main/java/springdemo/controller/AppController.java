package springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springdemo.model.Authorities;
import springdemo.model.MyUser;
import springdemo.service.MyUserService;

@Controller
public class AppController {

    private final MyUserService service;

    @Autowired
    public AppController(MyUserService service) {
        this.service = service;
    }

    @GetMapping("/control-panel")
    public String showControlPanel(Model model){

        model.addAttribute("myUser", new MyUser());
        model.addAttribute("authorities", Authorities.values());

        return "control-panel";
    }

    @PostMapping("/add-user")
    public String addUser(MyUser myUser){

        service.saveUser(myUser);
        return "control-panel";
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
