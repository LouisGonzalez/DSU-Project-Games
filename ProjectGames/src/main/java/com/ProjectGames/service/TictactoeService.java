package com.ProjectGames.service;

import com.ProjectGames.model.Game;

import java.util.ArrayList;

public interface TictactoeService {

    public ArrayList<Game> getGames();
    public void setGames(ArrayList<Game> games);

}