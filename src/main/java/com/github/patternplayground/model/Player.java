package com.github.patternplayground.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@ElementCollection
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Card> deck;
	private Long wins;
	private Long loses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public Long getWins() {
		return wins;
	}

	public void setWins(Long wins) {
		this.wins = wins;
	}

	public void addWin() {
		this.setWins(this.getWins() + 1);
	}

	public Long getLoses() {
		return loses;
	}

	public void setLoses(Long loses) {
		this.loses = loses;
	}

	public void addLose() {
		this.setLoses(this.getLoses() + 1);
	}
}
