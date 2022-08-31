package com.ProjectGames.controller;

import com.ProjectGames.model.Player;

import java.util.ArrayList;

public abstract class GameController {

    private ArrayList<IPlayerGeneral> generalList;

    public GameController(ArrayList<IPlayerGeneral> generalList){
        this.generalList = generalList;
    }

    public ArrayList<Player> selectPlayer(GamePlayersProvider listProviders, ArrayList<Integer> idPlayers){
        return listProviders.getPlayersGeneralList(idPlayers);
    }

    public abstract void go();

    public abstract void turn();


}
