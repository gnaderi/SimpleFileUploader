package com.nhl.simplefileuploader.service;

import com.nhl.simplefileuploader.entity.FileBag;
import com.nhl.simplefileuploader.repository.FileCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleFileStoreService implements FileStoreService {
    @Autowired
    private FileCrudRepository fileCrudRepository;

    @Transactional
    @Override
    public FileBag save(FileBag fileBag) {
        return fileCrudRepository.save(fileBag);
    }

    @Override
    public List<FileBag> findAll() {
        final List<FileBag> fileBags = new ArrayList<>();
        fileCrudRepository.findAll().forEach(fileBags::add);
        return fileBags;
    }

    @Override
    public FileBag findByName(String filename) {
        return fileCrudRepository.findByName(filename);
    }

    @Transactional
    @Override
    public void deleteAll() {
        fileCrudRepository.deleteAll();
    }
}