package com.dagabienkowska.documentmanager.services;

import com.dagabienkowska.documentmanager.models.Document;
import com.dagabienkowska.documentmanager.repository.DocumentRepository;
import com.dagabienkowska.documentmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class DocumentServiceImpl implements DocumentService{

    //private final UserRepository userRepository;
    private final DocumentRepository documentRepository;
    private final SecurityService securityService;

    public DocumentServiceImpl(/*UserRepository userRepository,*/ DocumentRepository documentRepository, SecurityService securityService) {
        //this.userRepository = userRepository;
        this.documentRepository = documentRepository;
        this.securityService = securityService;
    }

    @Override
    public void addDocument(Document document) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        document.setCreatetionDate(timestamp);
        document.setModificationDate(timestamp);

        String username = securityService.findLoggedInUsername();
        //Long userId = userRepository.findByUsername(username).getUserId();
        //document.setDocId(userId);

        documentRepository.save(document);
    }

    @Override
    public void modifyDocument(Document document) {

    }

    @Override
    public void deleteDocument(Long id) {

    }

    @Override
    public Document findByUsername(String username) {
        return null;
    }

    @Override
    public Document findByFileName(String fileName) {
        return documentRepository.findByFileName(fileName);
    }
}