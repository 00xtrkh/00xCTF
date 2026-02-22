package com._xCTF.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._xCTF.models.CTFOwner;

@Repository
public interface CTFOwnerRepository extends JpaRepository<CTFOwner, Long> {

  List<CTFOwner> findByCtfId(Long ctfId);

  List<CTFOwner> findByUserId(Long userId);

  boolean existsByCtfIdAndUserId(Long ctfId, Long userId);
}
