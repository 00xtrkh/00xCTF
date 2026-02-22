package com._xCTF.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._xCTF.models.Flag;

@Repository
public interface FlagRepository extends JpaRepository<Flag, Long> {

  List<Flag> findByChallengeId(Long challengeId);
}
