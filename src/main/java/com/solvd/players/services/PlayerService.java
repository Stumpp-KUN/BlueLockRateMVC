package com.solvd.players.services;

import com.solvd.players.dao.mySQL.PlayerDAO;
import com.solvd.players.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {
    //@Autowired
    private PlayerDAO playerDAO=new PlayerDAO();

//    @Transactional
    public List<Player> getAllPlayers(){
        return playerDAO.getAllPlayers();
    }

//    @Transactional
    public void savePlayer(Player player){
        playerDAO.createEntity(player);
    }

    public Player getPlayer(int id){
        return playerDAO.getEntityById(id);
    }

    public void deletePlayer(int id){
        playerDAO.deleteEntity(id);
    }


}
