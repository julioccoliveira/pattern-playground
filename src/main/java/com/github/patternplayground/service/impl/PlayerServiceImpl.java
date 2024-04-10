package com.github.patternplayground.service.impl;

import com.github.patternplayground.model.Player;
import com.github.patternplayground.model.PlayerRepository;
import com.github.patternplayground.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public Iterable<Player> findAll() {
		return playerRepository.findAll();
	}

	@Override
	public Player findById(Long id) {
		return playerRepository.findById(id)
				.orElse(null);
	}

	@Override
	public void insert(Player player) {
		playerRepository.save(player);
	}

	@Override
	public void update(Long id, Player player) {
		Optional<Player> optionalPlayer =  playerRepository.findById(id);
		if (optionalPlayer.isPresent()) {
			Player updatedPlayer = optionalPlayer.get();
			updatedPlayer.setDeck(player.getDeck());
			updatedPlayer.setName(player.getName());
			updatedPlayer.setWins(player.getWins());
			updatedPlayer.setLoses(player.getLoses());
		}
	}

	@Override
	public void delete(Long id) {
		playerRepository.deleteById(id);
	}

}
