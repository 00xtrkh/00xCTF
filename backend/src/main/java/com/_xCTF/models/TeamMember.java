package com._xCTF.models;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "team_members", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "team_id", "user_id" })
})
public class TeamMember {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "team_member_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "team_id", nullable = false)
  private Team team;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @CreationTimestamp
  @Column(name = "joined_at", updatable = false)
  private Timestamp joinedAt;
}
