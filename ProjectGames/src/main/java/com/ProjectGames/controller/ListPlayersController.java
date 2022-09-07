package com.ProjectGames.controller;

import com.ProjectGames.model.Player;
import com.ProjectGames.model.Principal;

import java.util.ArrayList;

public class ListPlayersController implements GamePlayersProvider {

    public ArrayList<Player> getPlayersGeneralList(ArrayList<Integer> idPlayers){
        ArrayList<Player> listPlayers = new ArrayList<>();
        for(int i = 0; i < idPlayers.size(); i++){
            listPlayers.add(Principal.players.get(idPlayers.get(i)));
        }
        return listPlayers;
    }

}

