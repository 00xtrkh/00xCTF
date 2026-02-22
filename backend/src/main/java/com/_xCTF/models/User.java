package com._xCTF.models;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com._xCTF.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "user_id")
  private Long id;

  @Column(name = "user_name", unique = true, nullable = false)
  private String username;

  @Column(name = "user_email", unique = true, nullable = false)
  private String email;

  @Column(name = "password_hash", columnDefinition = "TEXT")
  private String passwordHash;

  @Column(name = "user_role")
  @Enumerated(EnumType.STRING)
  private UserRole role;

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

}
