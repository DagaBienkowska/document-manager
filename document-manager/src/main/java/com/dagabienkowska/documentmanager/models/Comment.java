package com.dagabienkowska.documentmanager.models;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commId;
    private String content;

    @ManyToOne
    @MapsId
    private User user;

    @ManyToOne
    @MapsId
    private Document document;

    public Comment(String content) {
        this.content = content;
    }

    public Comment() {
    }

    public long getCommId() {
        return commId;
    }

    public void setCommId(long commId) {
        this.commId = commId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commId=" + commId +
                ", content='" + content + '\'' +
                ", userId=" + user +
                '}';
    }
}
