package com._xCTF.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hints")
public class Hint {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "hint_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "challenge_id", nullable = false)
  private Challenge challenge;

  @Column(name = "content", columnDefinition = "TEXT")
  private String content;

  @Column(name = "cost")
  private int cost;
}
