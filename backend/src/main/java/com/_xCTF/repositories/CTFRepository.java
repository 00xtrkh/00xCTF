package com._xCTF.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._xCTF.models.CTF;

@Repository
public interface CTFRepository extends JpaRepository<CTF, Long> {

  List<CTF> findByIsPublicTrue();

  List<CTF> findByIsActiveTrue();

  List<CTF> findByIsDeletedFalseOrIsDeletedIsNull();
}
