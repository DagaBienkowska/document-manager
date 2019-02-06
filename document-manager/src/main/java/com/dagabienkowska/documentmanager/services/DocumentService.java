package com.dagabienkowska.documentmanager.services;

import com.dagabienkowska.documentmanager.models.Document;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface DocumentService {

    void addDocument(Document document);

    void modifyDocument(Document document);

    void deleteDocument(Long id);

    Document findByUsername(String username);

    Document findByFileName(String fileName);
}
