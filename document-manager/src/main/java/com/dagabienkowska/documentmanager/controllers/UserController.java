package com.dagabienkowska.documentmanager.controllers;

import com.dagabienkowska.documentmanager.UserValidator;
import com.dagabienkowska.documentmanager.models.User;
import com.dagabienkowska.documentmanager.services.SecurityService;
import com.dagabienkowska.documentmanager.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private final UserService userService;
    private final SecurityService securityService;
    //private final UserValidator userValidator;

    public UserController(UserService userRepository1, SecurityService securityService) {
        this.userService = userRepository1;
        this.securityService = securityService;

    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        /*
        userValidator.validate("userForm", bindingResult);

        if (bindingResult.hasErrors()){
            return "registration";
        }
        */
        userService.saveUser(userForm);
        securityService.login(userForm.getUsername(), userForm.getPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout){

        if (error !=null){
            model.addAttribute("error", "Your username and password is invalid");
        }

        if (logout !=null){
            model.addAttribute("message", "Logged out successfully");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model){
        return "welcome";
    }

}
