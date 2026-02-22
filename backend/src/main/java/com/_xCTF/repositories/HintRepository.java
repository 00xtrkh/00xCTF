package com._xCTF.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._xCTF.models.Hint;

@Repository
public interface HintRepository extends JpaRepository<Hint, Long> {

  List<Hint> findByChallengeId(Long challengeId);
}
