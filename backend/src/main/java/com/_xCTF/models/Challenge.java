package com._xCTF.models;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com._xCTF.enums.ChallengeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "challenges")
public class Challenge {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "challenge_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "ctf_id", nullable = false)
  private CTF ctf;

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "category", length = 50)
  private String category;

  @Column(name = "initial_value")
  private int initialValue;

  @Column(name = "min_value")
  private int minValue;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private ChallengeType type;

  @Column(name = "visible")
  private Boolean visible;

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

  @OneToMany(mappedBy = "challenge")
  private List<Flag> flags;

  @OneToMany(mappedBy = "challenge")
  private List<Hint> hints;

  @OneToMany(mappedBy = "challenge")
  private List<Attachment> attachments;

  @OneToMany(mappedBy = "challenge")
  private List<Submission> submissions;
}
