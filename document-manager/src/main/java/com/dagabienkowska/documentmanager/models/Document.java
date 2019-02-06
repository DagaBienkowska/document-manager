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
    private Timestamp createtionDate;
    private Timestamp modificationDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    private Blob pdfFile;

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

    public Date getCreatetionDate() {
        return createtionDate;
    }

    public void setCreatetionDate(Timestamp createtionDate) {
        this.createtionDate = createtionDate;
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

    public Blob getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(Blob pdfFile) {
        this.pdfFile = pdfFile;
    }

    @Override
    public String toString() {
        return "Document{" +
                "docId=" + docId +
                ", fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                ", createtionDate=" + createtionDate +
                ", modificationDate=" + modificationDate +
                '}';
    }
}
