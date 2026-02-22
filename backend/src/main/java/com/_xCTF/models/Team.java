package com._xCTF.models;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "teams")
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "team_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "ctf_id", nullable = false)
  private CTF ctf;

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "invite_code", length = 32)
  private String inviteCode;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Timestamp updatedAt;

  @Column(name = "deleted_at")
  private Timestamp deletedAt;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "is_deleted")
  private Boolean isDeleted;

  // --- Relationships ---

  @OneToMany(mappedBy = "team")
  private List<TeamMember> members;

  @OneToMany(mappedBy = "team")
  private List<Submission> submissions;
}
