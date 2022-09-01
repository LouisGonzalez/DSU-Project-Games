package com.ProjectGames.service;

import com.ProjectGames.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlayerService {
    public static ArrayList<Player> playerList = new ArrayList<>();

    public PlayerService() {
        playerList.add(new Player("Boot1", 0, 0));
        playerList.add(new Player("Boot2", 5, 1));
    }

    public ArrayList<Player> ShowPlayers() {
        return playerList;
    }

    public void createPlayer(String name, int age, int id) {
        Player player = new Player(name, age, id);
        player.setid(id);
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

        /*public Player updatePlayer (Player players) {
        playerList.stream().filter(e -> e.getid() == players.getid()).forEach(e->{
            e.setName(players.getName());
            e.setAge((players.getAge()));
        });*/

/* public Player updatePlayer (int id, Player players) {
            int index = 0;
            for(Player p: playerList){
                if(p.getid()==id){
                    players.setid(id);
                    playerList.set(index,players);
                }
            }
            return players;
        }*/
/**/