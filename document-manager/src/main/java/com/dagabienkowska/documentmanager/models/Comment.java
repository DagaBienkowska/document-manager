package com.dagabienkowska.documentmanager.models;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commId;
    private String content;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "doc_id")
    private Document commentTo;

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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Document getCommentTo() {
        return commentTo;
    }

    public void setCommentTo(Document commentTo) {
        this.commentTo = commentTo;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commId=" + commId +
                ", content='" + content + '\'' +
                '}';
    }
}
