package com.dagabienkowska.documentmanager.services;

import com.dagabienkowska.documentmanager.models.DBFile;
import com.dagabienkowska.documentmanager.repository.DBFileRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Path;

@Service
public class DBFileStorageServiceImpl implements DBFileStorageService{

    private final DBFileRepository dbFileRepository;

    public DBFileStorageServiceImpl(DBFileRepository dbFileRepository) {
        this.dbFileRepository = dbFileRepository;
    }

    public DBFile storeFile(MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException e) {
           e.printStackTrace();
        }
        return null;
    }

}
