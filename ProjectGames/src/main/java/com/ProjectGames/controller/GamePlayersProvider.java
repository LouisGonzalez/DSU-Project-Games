package com.ProjectGames.controller;

import com.ProjectGames.model.Player;

import java.util.ArrayList;

public interface GamePlayersProvider {

    public ArrayList<Player> getPlayersGeneralList(ArrayList<Integer> idPlayers);

}
