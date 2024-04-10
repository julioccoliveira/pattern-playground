package com.github.patternplayground.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Card {

	@Id
	private Long id;
	private String name;
	private Long attack;
	private Long defense;

	public Long getDefense() {
		return defense;
	}

	public void setDefense(Long defense) {
		this.defense = defense;
	}

	public Long getAttack() {
		return attack;
	}

	public void setAttack(Long attack) {
		this.attack = attack;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
