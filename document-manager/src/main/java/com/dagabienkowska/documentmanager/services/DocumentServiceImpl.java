package com.dagabienkowska.documentmanager.services;

import com.dagabienkowska.documentmanager.models.Document;
import com.dagabienkowska.documentmanager.repository.DocumentRepository;
import com.dagabienkowska.documentmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class DocumentServiceImpl implements DocumentService{

    private final UserRepository userRepository;
    private final DocumentRepository documentRepository;
    private static final Logger LOGGER = Logger.getLogger(DocumentServiceImpl.class.getName());

    public DocumentServiceImpl(UserRepository userRepository, DocumentRepository documentRepository) {
        this.userRepository = userRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public void addDocument(Document document) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        document.setCreatetionDate(timestamp);
        document.setModificationDate(timestamp);

        documentRepository.save(document);
        LOGGER.log(Level.INFO, "added new document");

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
