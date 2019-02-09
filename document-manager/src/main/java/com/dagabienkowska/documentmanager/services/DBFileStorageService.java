package com.dagabienkowska.documentmanager.services;

import com.dagabienkowska.documentmanager.models.DBFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface DBFileStorageService {

    DBFile storeFile(MultipartFile file);
}
