package com._xCTF.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._xCTF.models.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

  List<Submission> findByCtfId(Long ctfId);

  List<Submission> findByUserId(Long userId);

  List<Submission> findByTeamId(Long teamId);

  List<Submission> findByChallengeId(Long challengeId);

  List<Submission> findByCtfIdAndCorrectTrue(Long ctfId);

  Optional<Submission> findByUserIdAndChallengeId(Long userId, Long challengeId);

  boolean existsByUserIdAndChallengeId(Long userId, Long challengeId);
}
