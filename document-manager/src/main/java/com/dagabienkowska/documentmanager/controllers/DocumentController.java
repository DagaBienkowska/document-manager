package com.dagabienkowska.documentmanager.controllers;

import com.dagabienkowska.documentmanager.components.DocumentValidator;
import com.dagabienkowska.documentmanager.models.DBFile;
import com.dagabienkowska.documentmanager.models.Document;
import com.dagabienkowska.documentmanager.models.User;
import com.dagabienkowska.documentmanager.repository.DocumentRepository;
import com.dagabienkowska.documentmanager.services.*;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class DocumentController {

    private final UserService userService;
    private final DocumentService documentService;
    private final DocumentValidator documentValidator;
    private final SecurityService securityService;
    private final DBFileStorageService dbFileStorageService;
    private static final Logger LOGGER = Logger.getLogger(DocumentController.class.getName());

    public DocumentController(UserService userService, DocumentService documentService,
                              DocumentValidator documentValidator, SecurityService securityService,
                              DocumentRepository documentRepository, DBFileStorageService dbFileStorageService) {
        this.userService = userService;
        this.documentService = documentService;
        this.documentValidator = documentValidator;
        this.securityService = securityService;
        this.dbFileStorageService = dbFileStorageService;


    }


    @RequestMapping(value = "/addDocument", method = RequestMethod.GET)
    public String addDocument(Model model){
        model.addAttribute("documentForm", new Document());
        return "addDocument";
    }
    @RequestMapping(value = "/addDocument", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addDocument(@ModelAttribute("documentForm") Document documentForm,
                              BindingResult bindingResult,
                              @RequestParam("pdfFile")MultipartFile multipartFile){
        DBFile dbFile = dbFileStorageService.storeFile(multipartFile);

        documentValidator.validate(documentForm, bindingResult);
/*
        if (bindingResult.hasErrors()){
            LOGGER.log(Level.INFO, "Error ");
            return "addDocument";
        }
*/
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        documentForm.setCreationDate(timestamp);
        documentForm.setModificationDate(timestamp);

        String username = securityService.findLoggedInUsername();
        LOGGER.log(Level.INFO, "username " +username);

        User user = userService.findByUsername(username);
        documentForm.setCreator(user);
        LOGGER.log(Level.INFO, "added creator " +user.toString());
        dbFile.setDocument(documentForm);
        documentService.addDocument(documentForm);

        return "redirect:/welcome";
    }

}
