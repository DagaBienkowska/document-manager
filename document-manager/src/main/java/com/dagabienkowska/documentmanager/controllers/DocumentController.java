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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;
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
    public String addDocument(@ModelAttribute("documentForm") Document documentForm, BindingResult bindingResult,
                              @RequestParam("file")MultipartFile multipartFile, Model model){

        DBFile dbFile = dbFileStorageService.storeFile(multipartFile);

        if (multipartFile.isEmpty()){
            model.addAttribute("error", "No file attached");

            return "addDocument";
        }

        if (!multipartFile.getContentType().equalsIgnoreCase("application/pdf") ){
            model.addAttribute("error", "Attached file is not a pdf file");

            return "addDocument";
        }

        documentValidator.validate(documentForm, bindingResult);

        if (bindingResult.hasErrors()){
            LOGGER.log(Level.INFO, "Error ");
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors ) {
                System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
            }
            return "addDocument";
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        documentForm.setCreationDate(timestamp);
        documentForm.setModificationDate(timestamp);

        String username = securityService.findLoggedInUsername();
        LOGGER.log(Level.INFO, "username " +username);

        User user = userService.findByUsername(username);
        documentForm.setCreator(user);
        LOGGER.log(Level.INFO, "added creator " +user.toString());
        documentForm.setPdfFile(dbFile);
        documentService.addDocument(documentForm);

        return "redirect:/welcome";
    }

}
