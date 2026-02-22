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
@Table(name = "submissions", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "user_id", "challenge_id" })
})
public class Submission {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "submission_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "ctf_id", nullable = false)
  private CTF ctf;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;

  @ManyToOne
  @JoinColumn(name = "challenge_id", nullable = false)
  private Challenge challenge;

  @Column(name = "correct")
  private Boolean correct;

  @CreationTimestamp
  @Column(name = "submitted_at", updatable = false)
  private Timestamp submittedAt;
}
