package com.naderi.sfu.repository;

import com.naderi.sfu.entity.FileBag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface FileCrudRepository extends CrudRepository<FileBag, Long> {
    @Query("select f from FileBag f where f.fileName = :fileName")
    FileBag findByName(@Param("fileName") String fileName);
}
