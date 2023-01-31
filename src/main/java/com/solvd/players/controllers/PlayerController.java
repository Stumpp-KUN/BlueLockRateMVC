package com.solvd.players.controllers;

import com.solvd.players.dao.IPlayerDAO;
import com.solvd.players.dao.mySQL.PlayerDAO;
import com.solvd.players.models.Player;
import com.solvd.players.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlayerController {
    //@Autowired
    private PlayerService playerService=new PlayerService();

    @RequestMapping ("/")
    public String rateView(Model model){
        List<Player> playerList=playerService.getAllPlayers();
        model.addAttribute("allPlayers",playerList);
        return "rateView";
    }

    @RequestMapping("/addNewPlayer")
    public String addNewPlayer(Model model){
        Player player=new Player();
        model.addAttribute("player",player);
    return "addNewPlayer";
    }

    @RequestMapping("/savePlayer")
    public String savePlayer(@ModelAttribute("player") Player player){
        playerService.savePlayer(player);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updatePlayer(@RequestParam("playerId") int id,Model model){
        Player player=playerService.getPlayer(id);
        model.addAttribute("player",player);
        return "addNewPlayer";
    }

    @RequestMapping("/deletePlayer")
    public String deletePlayer(@RequestParam("playerId") int id){
        playerService.deletePlayer(id);
        return "redirect:/";
    }

}
