package com._xCTF.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._xCTF.models.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

  List<Team> findByCtfId(Long ctfId);

  Optional<Team> findByInviteCode(String inviteCode);
}
