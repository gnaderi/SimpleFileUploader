package com.nhl.simplefileuploader.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FileBag")
public class FileBag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String fileName;
    @Column
    private String contentType;
    @Column
    private long fileSize;
    @Column
    private Date creationDate;
    @Column
    private Date updatedDate;
    @Lob
    @Column
    private byte[] content;

    public FileBag() {
    }

    public FileBag(String fileName, String contentType, Date creationDate, Date updatedDate, byte[] content) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = content.length;
        this.creationDate = creationDate;
        this.updatedDate = updatedDate;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}