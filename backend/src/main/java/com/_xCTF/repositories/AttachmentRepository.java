package com._xCTF.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._xCTF.models.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

  List<Attachment> findByChallengeId(Long challengeId);

  List<Attachment> findByChallengeIdAndVisibleTrue(Long challengeId);
}
