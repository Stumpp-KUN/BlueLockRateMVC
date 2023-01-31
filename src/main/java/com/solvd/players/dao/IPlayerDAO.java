package com.solvd.players.dao;

import com.solvd.players.models.Player;

import java.util.List;

public interface IPlayerDAO extends IBaseDAO<Player>{
    List<Player> getAllPlayers();
}
