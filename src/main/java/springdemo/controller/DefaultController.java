package springdemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class DefaultController {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @GetMapping(path = "/defaultUserPage")
    public String showDefaultUserPage(HttpServletRequest request){

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        logger.info("username " + username);

        if(request.isUserInRole("ADMIN")){
            return "settings";
        }else if(request.isUserInRole("MANAGER")){
            return "leaders";
        } else if(request.isUserInRole("EMPLOYEE")){
            return "employee";
        }

        return "controlPanel";
    }

}
