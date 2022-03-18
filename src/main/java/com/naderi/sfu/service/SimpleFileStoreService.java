package com.naderi.sfu.service;

import com.naderi.sfu.repository.FileCrudRepository;
import com.naderi.sfu.entity.FileBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleFileStoreService implements FileStoreService {
    private FileCrudRepository fileCrudRepository;

    @Autowired
    public SimpleFileStoreService(FileCrudRepository fileCrudRepository) {
        this.fileCrudRepository = fileCrudRepository;
    }

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