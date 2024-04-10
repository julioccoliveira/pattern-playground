package com.github.patternplayground.service;

import com.github.patternplayground.model.Player;

public interface PlayerService {

	Iterable<Player> findAll();
	Player findById(Long id);
	void insert(Player player);
	void update(Long id, Player player);
	void delete(Long id);

}
