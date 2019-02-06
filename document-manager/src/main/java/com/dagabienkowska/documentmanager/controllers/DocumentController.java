package com.dagabienkowska.documentmanager.controllers;

import com.dagabienkowska.documentmanager.components.DocumentValidator;
import com.dagabienkowska.documentmanager.models.Document;
import com.dagabienkowska.documentmanager.models.User;
import com.dagabienkowska.documentmanager.services.DocumentService;
import com.dagabienkowska.documentmanager.services.SecurityService;
import com.dagabienkowska.documentmanager.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class DocumentController {

    private final UserService userService;
    private final DocumentService documentService;
    private final DocumentValidator documentValidator;
    private final SecurityService securityService;
    private static final Logger LOGGER = Logger.getLogger(DocumentController.class.getName());

    public DocumentController(UserService userService, DocumentService documentService, DocumentValidator documentValidator, SecurityService securityService) {
        this.userService = userService;
        this.documentService = documentService;
        this.documentValidator = documentValidator;
        this.securityService = securityService;
    }


    @RequestMapping(value = "addFile", method = RequestMethod.GET)
    public String addFile(Model model){
        model.addAttribute("documentForm", new Document());
        return "addFile";
    }
    @RequestMapping(value = "/addFile", method = RequestMethod.POST)
    public String addFile(@ModelAttribute("documentForm") Document documentForm, BindingResult bindingResult, Model model,
                          Principal principal){

        documentValidator.validate(documentForm, bindingResult);

        if (bindingResult.hasErrors()){
            return "addFile";
        }
/*
        String username = principal.getName();
        LOGGER.log(Level.INFO, "got username " + username);
        User user = userService.findByUsername(username);
        LOGGER.log(Level.INFO, "got user " + user.toString());
        LOGGER.log(Level.INFO, "cos" + documentForm.toString());
        documentForm.setCreator(user);
        */
        documentService.addDocument(documentForm);

        return "redirect:/welcome";
    }
}
