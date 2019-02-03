package com.dagabienkowska.documentmanager.controllers;

import com.dagabienkowska.documentmanager.components.DocumentValidator;
import com.dagabienkowska.documentmanager.models.Document;
import com.dagabienkowska.documentmanager.services.DocumentService;
import com.dagabienkowska.documentmanager.services.SecurityService;
import com.dagabienkowska.documentmanager.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DocumentController {

    private final UserService userService;
    private final DocumentService documentService;
    private final DocumentValidator documentValidator;

    public DocumentController(UserService userService, DocumentService documentService, DocumentValidator documentValidator) {
        this.userService = userService;
        this.documentService = documentService;
        this.documentValidator = documentValidator;
    }


    @RequestMapping(value = "addFile", method = RequestMethod.GET)
    public String addFile(Model model){
        model.addAttribute("documentForm", new Document());
        return "addFile";
    }
    @RequestMapping(value = "/addFile", method = RequestMethod.POST)
    public String registration(@ModelAttribute("documentForm") Document documentForm, BindingResult bindingResult, Model model){

        documentValidator.validate(documentForm, bindingResult);

        if (bindingResult.hasErrors()){
            return "addFile";
        }

        documentService.addDocument(documentForm);

        return "redirect:/welcome";
    }
}
