package com.nhl.simplefileuploader.service;

import com.nhl.simplefileuploader.entity.FileBag;

import java.util.List;

public interface FileStoreService {

    FileBag save(FileBag fileBag);

    List<FileBag> findAll();

    FileBag findByName(String filename);

    void deleteAll();
}