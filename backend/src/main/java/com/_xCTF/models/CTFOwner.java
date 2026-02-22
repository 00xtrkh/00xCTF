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
@Table(name = "ctf_owners", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "ctf_id", "user_id" })
})
public class CTFOwner {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "ctf_owner_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "ctf_id", nullable = false)
  private CTF ctf;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @CreationTimestamp
  @Column(name = "assigned_at", updatable = false)
  private Timestamp assignedAt;
}
