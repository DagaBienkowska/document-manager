package com.dagabienkowska.documentmanager.models;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


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
    @MapsId
    private User user;

    @OneToMany(mappedBy = "document")
    private List<Comment> comments;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
                ", creator=" + user +
                ", comments=" + comments +
                '}';
    }
}
