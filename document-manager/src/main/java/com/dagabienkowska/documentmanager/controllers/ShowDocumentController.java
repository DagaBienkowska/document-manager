package com.dagabienkowska.documentmanager.controllers;

import com.dagabienkowska.documentmanager.models.Document;
import com.dagabienkowska.documentmanager.services.DocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class ShowDocumentController {

    private final DocumentService documentService;
    private static final Logger LOGGER = Logger.getLogger(ShowDocumentController.class.getName());

    public ShowDocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping(value = "showDocument", method = RequestMethod.GET)
    public String showDocument(@RequestParam("docName") String docName, Map<String, Object> map){


        try {
            map.put("documentList", documentService.findByFileName(docName));
            LOGGER.log(Level.INFO, "Fetched file " + docName.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

        return "showDocument";
    }
}
