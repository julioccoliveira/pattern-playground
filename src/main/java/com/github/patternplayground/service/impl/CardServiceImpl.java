package com.github.patternplayground.service.impl;

import com.github.patternplayground.model.Card;
import com.github.patternplayground.model.CardRepository;
import com.github.patternplayground.service.CardService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
	@Autowired
	private CardRepository cardRepository;


	@Override
	public Iterable<Card> findAll() {
		return cardRepository.findAll();
	}

	@Override
	public Card findById(Long id) {
		return cardRepository.findById(id)
				.orElse(null);
	}

	@Override
	public void insert(Card card) {
		cardRepository.save(card);

	}

	@Override
	public void update(Long id, Card card) {
		Optional<Card> optionalCard = cardRepository.findById(id);
		if (optionalCard.isPresent()) {
			Card updatedCard = optionalCard.get();
			updatedCard.setAttack(card.getAttack());
			updatedCard.setDefense(card.getDefense());
			updatedCard.setName(card.getName());
			cardRepository.save(updatedCard);
		}

	}

	@Override
	public void delete(Long id) {
		cardRepository.deleteById(id);
	}

}
