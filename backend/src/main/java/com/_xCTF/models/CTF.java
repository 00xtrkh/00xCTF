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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ctfs")
public class CTF {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "ctf_id")
  private Long id;

  @Column(name = "name", length = 150, nullable = false)
  private String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "start_time")
  private Timestamp startAt;

  @Column(name = "end_time")
  private Timestamp endAt;

  @Column(name = "is_public")
  private Boolean isPublic;

  @Column(name = "is_active")
  private Boolean isActive;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Timestamp updatedAt;

  @Column(name = "deleted_at")
  private Timestamp deletedAt;

  @Column(name = "is_deleted")
  private Boolean isDeleted;

  // --- Relationships ---

  @OneToMany(mappedBy = "ctf")
  private List<Team> teams;

  @OneToMany(mappedBy = "ctf")
  private List<Challenge> challenges;

  @OneToMany(mappedBy = "ctf")
  private List<Submission> submissions;
}
