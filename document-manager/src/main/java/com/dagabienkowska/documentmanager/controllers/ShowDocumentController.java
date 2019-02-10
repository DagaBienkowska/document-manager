package com.dagabienkowska.documentmanager.controllers;

import com.dagabienkowska.documentmanager.models.DBFile;
import com.dagabienkowska.documentmanager.models.Document;
import com.dagabienkowska.documentmanager.services.DBFileStorageService;
import com.dagabienkowska.documentmanager.services.DocumentService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class ShowDocumentController {

    private final DocumentService documentService;
    private final DBFileStorageService dbFileStorageService;
    private static final Logger LOGGER = Logger.getLogger(ShowDocumentController.class.getName());

    public ShowDocumentController(DocumentService documentService, DBFileStorageService dbFileStorageService) {
        this.documentService = documentService;
        this.dbFileStorageService = dbFileStorageService;
    }

    @RequestMapping(value = "showDocument", method = RequestMethod.GET)
    public String showDocument(){




        return "showDocument";
    }

    @RequestMapping(value = "showDocument", method = RequestMethod.POST)
    public String showDocument(@RequestParam("docName") String docName, Map<String, Object> map, HttpServletResponse response){
        
        try {
            map.put("document", documentService.findByFileName(docName));
            LOGGER.log(Level.INFO, "Fetched file " + docName.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "showDocument";
    }
}
