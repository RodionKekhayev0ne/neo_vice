package com.example.demo.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "pages")
@Data
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }


    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "header", nullable = false)
    private String header;

    @Column(name = "content", nullable = false)
    private String description;

    @Column(name = "email", nullable = false)
    private String email;

    private String number;

    private String preview;

    @Column(name = "company_name", nullable = false)
    private String companyName;


    private Integer adminId;

    @Column(name = "publishing_date", nullable = false)
    private Date publishingDate;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return description;
    }

    public void setContent(String content) {
        this.description = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public Integer getCreator() {
        return adminId;
    }

    public void setCreator(Integer creator) {
        this.adminId = creator;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }
    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

}
