package com.github.patternplayground.controller;

import com.github.patternplayground.model.Player;
import com.github.patternplayground.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("players")
public class PlayerRestController {

	@Autowired
	private PlayerService playerService;

	@GetMapping
	public ResponseEntity<Iterable<Player>> findAll() {
		return ResponseEntity.ok(playerService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Player> findById(@PathVariable Long id) {
		return ResponseEntity.ok(playerService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Player> insertPlayer(@RequestBody Player player) {
		playerService.insert(player);
		return ResponseEntity.ok(player);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
		playerService.update(id, player);
		return ResponseEntity.ok(player);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
		playerService.delete(id);
		return ResponseEntity.ok().build();
	}
}
