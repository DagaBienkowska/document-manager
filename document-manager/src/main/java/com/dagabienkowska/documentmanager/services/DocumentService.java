package com.dagabienkowska.documentmanager.services;

import com.dagabienkowska.documentmanager.models.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public interface DocumentService {

    void addDocument(Document document);

    void modifyDocument(Document document);

    void deleteDocument(Long id);

    Document findByUsername(String username);

    Document findByFileName(String fileName);

    Page<Document> documentList(Pageable pageable);

}
