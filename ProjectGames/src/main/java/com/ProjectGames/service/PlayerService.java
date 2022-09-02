package com.ProjectGames.service;

import com.ProjectGames.DTO.PlayerDTO;
import com.ProjectGames.model.Player;
import com.ProjectGames.model.Principal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    public boolean exists(String username){
        for (Player player: Principal.players) {
            if(username.equals(player.getName())){
                return true;
            }
        }
        return false;
    }

    public List<PlayerDTO> findPlayersInfo(){
        List<PlayerDTO> listPlayers = new ArrayList<>();
        for (int i = 0; i < Principal.players.size(); i++) {
            Player auxPlayer = Principal.players.get(i);
            PlayerDTO playerSend = new PlayerDTO(i, auxPlayer.getName(), auxPlayer.getTypePlayer(), auxPlayer.getAge());
            listPlayers.add(playerSend);
        }
        return listPlayers;
    }

}
