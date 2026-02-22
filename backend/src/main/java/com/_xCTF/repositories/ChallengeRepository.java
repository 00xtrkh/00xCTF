package com._xCTF.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._xCTF.models.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

  List<Challenge> findByCtfId(Long ctfId);

  List<Challenge> findByCtfIdAndVisibleTrue(Long ctfId);

  List<Challenge> findByCtfIdAndCategory(Long ctfId, String category);
}
