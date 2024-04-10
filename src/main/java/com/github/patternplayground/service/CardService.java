package com.github.patternplayground.service;

import com.github.patternplayground.model.Card;
import org.springframework.context.annotation.Bean;

public interface CardService {

	Iterable<Card> findAll();
	Card findById(Long id);
	void insert(Card card);
	void update(Long id, Card card);
	void delete(Long id);

}
