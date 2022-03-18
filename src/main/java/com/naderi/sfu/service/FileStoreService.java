package com.naderi.sfu.service;

import com.naderi.sfu.entity.FileBag;

import java.util.List;

public interface FileStoreService {

    FileBag save(FileBag fileBag);

    List<FileBag> findAll();

    FileBag findByName(String filename);

    void deleteAll();
}