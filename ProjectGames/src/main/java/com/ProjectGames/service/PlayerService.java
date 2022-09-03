package com.ProjectGames.service;

import com.ProjectGames.model.Player;
import com.ProjectGames.model.TypePlayer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlayerService {
    public static ArrayList<Player> playerList = new ArrayList<>();
    TypePlayer typePlayer;

    public PlayerService() {
        playerList.add(new Player("Boot1", "Bot", 0, 0));
        playerList.add(new Player("Boot2", "Bot", 1,15));
    }

    public ArrayList<Player> ShowPlayers() {
        return playerList;
    }

    public void createPlayer(String name, String type, int age, int id) {

        Player player = new Player(name,type, age, id);
        player.setid(id);
        player.setTypePlayer(TypePlayer.valueOf(type));
        player.setName(name);
        player.setAge(age);
        playerList.add(player);
    }

    public Player readPlayer(String name) {
        for (Player player : playerList) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    public void updatePlayer(Player players) {
        playerList.stream().filter(e -> e.getid() == players.getid()).forEach(e -> {
            e.setName(players.getName());
            e.setAge(players.getAge());
        });
    }


            public Player removePlayer (int id){
                Player player = getOne(id);
                playerList.remove(player);
                return player;
            }

          public Player getOne(int id) {
              Player player = null;
              for (int i = 0; i < playerList.size(); i++) {
                  if (playerList.get(i).getid() == id) {
                      player = playerList.get(i);
                  }
              }
              return player;
          }
}
