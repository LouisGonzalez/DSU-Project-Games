package com.ProjectGames.model;

import com.ProjectGames.controller.IPlayerGeneral;
import com.ProjectGames.controller.tictactoe.ITTTPlayer;
import com.ProjectGames.model.tictactoe.Board;

import java.util.ArrayList;

public abstract class Game {


    private boolean finished;
    private int guessingAttemps;
    public ArrayList<IPlayerGeneral> players;
    private ArrayList<IPlayerGeneral> generalList;
    private int totalPlayers;

    public Game(ArrayList<IPlayerGeneral> generalList, int totalPlayers){
        this.finished = false;
        this.guessingAttemps = 0;
        this.generalList = generalList;
        this.totalPlayers = totalPlayers;
    }

    public void setFinished(boolean finished){
        this.finished = finished;
    }

    public boolean getFinished(){
        return this.finished;
    }

    public void setGuessingAttemps(int guessingAttemps){
        this.guessingAttemps = guessingAttemps;
    }

    public int getGuessingAttemps(){
        return this.guessingAttemps;
    }

}
