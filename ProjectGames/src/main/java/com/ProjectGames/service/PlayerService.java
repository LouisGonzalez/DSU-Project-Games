package com.ProjectGames.service;

import com.ProjectGames.model.TypePlayer;
import java.util.ArrayList;
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


    public static ArrayList<Player> playerList = new ArrayList<>();
    TypePlayer typePlayer;


    public ArrayList<Player> ShowPlayers() {
        return playerList;
    }

    public Player readPlayer(String name) {
        for (Player player : playerList) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    /*public void updatePlayer(Player players) {
        playerList.stream().filter(e -> e.getid() == players.getid()).forEach(e -> {
            e.setName(players.getName());
            e.setAge(players.getAge());
        });
    }*/


            public Player removePlayer (int id){
                Player player = getOne(id);
                playerList.remove(player);
                return player;
            }

         public Player getOne(int id) {
              Player player = null;
              for (int i = 0; i < Principal.players.size(); i++) {
                  if (i == id) {
                      player = Principal.players.get(i);
                  }
              }
              return player;
          }
}
