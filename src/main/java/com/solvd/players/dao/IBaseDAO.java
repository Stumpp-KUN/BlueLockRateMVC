package com.solvd.players.dao;

import com.solvd.players.models.Player;

public interface IBaseDAO<T> {
    T getEntityById(int id);
    T createEntity(T player);
    void updateEntity(T player,int k);
    void deleteEntity(int id);
}
