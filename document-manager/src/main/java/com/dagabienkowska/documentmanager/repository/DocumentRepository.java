package com.dagabienkowska.documentmanager.repository;

import com.dagabienkowska.documentmanager.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    Document findByFileName(String fileName);
}
