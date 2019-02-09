package com.dagabienkowska.documentmanager.repository;

import com.dagabienkowska.documentmanager.models.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBFileRepository extends JpaRepository<DBFile, Long> {
}
