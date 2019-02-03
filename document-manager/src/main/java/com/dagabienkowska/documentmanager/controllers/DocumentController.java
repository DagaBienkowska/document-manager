package com.dagabienkowska.documentmanager.controllers;

import com.dagabienkowska.documentmanager.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DocumentController {

    private final UserService userService;

    public DocumentController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "addFile", method = RequestMethod.GET)
    public String addFile(Model model){
        return "addFile";
    }
}
