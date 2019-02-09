package com.dagabienkowska.documentmanager.models;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;



@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long docId;
    private String fileName;
    private String description;
    private Timestamp creationDate;
    private Timestamp modificationDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private DBFile pdfFile;


    public Document() {
    }

    public Document(String fileName, String description) {
        this.fileName = fileName;
        this.description = description;
    }

    public long getDocId() {
        return docId;
    }

    public void setDocId(long docId) {
        this.docId = docId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Timestamp modificationDate) {
        this.modificationDate = modificationDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public DBFile getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(DBFile pdfFile) {
        this.pdfFile = pdfFile;
    }

    @Override
    public String toString() {
        return "Document{" +
                "docId=" + docId +
                ", fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                '}';
    }
}
