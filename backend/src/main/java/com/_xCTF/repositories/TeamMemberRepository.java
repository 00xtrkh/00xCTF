package com._xCTF.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._xCTF.models.TeamMember;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

  List<TeamMember> findByTeamId(Long teamId);

  List<TeamMember> findByUserId(Long userId);

  Optional<TeamMember> findByTeamIdAndUserId(Long teamId, Long userId);

  boolean existsByTeamIdAndUserId(Long teamId, Long userId);
}
