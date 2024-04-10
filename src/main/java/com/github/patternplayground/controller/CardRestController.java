package com.github.patternplayground.controller;

import com.github.patternplayground.model.Card;
import com.github.patternplayground.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cards")
public class CardRestController {

	@Autowired
	private CardService cardService;

	@GetMapping
	public ResponseEntity<Iterable<Card>> getAllCards() {
		return ResponseEntity.ok(cardService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Card> getCardById(@PathVariable Long id) {
		return ResponseEntity.ok(cardService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Card> insertCard(@RequestBody Card card) {
		cardService.insert(card);
		return ResponseEntity.ok(card);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody Card card) {
		cardService.update(id, card);
		return ResponseEntity.ok(card);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
		cardService.delete(id);
		return ResponseEntity.ok().build();
	}
}
