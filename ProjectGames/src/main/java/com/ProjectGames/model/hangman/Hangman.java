package com.ProjectGames.model.hangman;

import com.ProjectGames.controller.IPlayerGeneral;
import com.ProjectGames.model.Game;
import com.ProjectGames.model.Player;
import com.ProjectGames.model.TypeGame;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties (value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Hangman extends Game {

    private int idGame;
    private Board myBoard;
    private Player playerGiver;
    private Player playerGuesser;


    public Hangman(ArrayList<Integer> idPlayers, int idGame, TypeGame typeGame){
        super(idPlayers, typeGame);
        this.myBoard = new Board();
        this.idGame = idGame;
        this.initPlayers();
    }

    public void initPlayers(){
        this.selectPlayers(this.listProviders);
        playerGiver = this.players.get(0);
        playerGuesser = this.players.get(1);
    }


    public void setMyBoard(Board myBoard){
        this.myBoard = myBoard;
    }

    public Board getMyBoard(){
        return this.myBoard;
    }

    public Player getPlayerGiver() {
        return playerGiver;
    }

    public void setPlayerGiver(Player playerGiver) {
        this.playerGiver = playerGiver;
    }

    public Player getPlayerGuesser() {
        return playerGuesser;
    }

    public void setPlayerGuesser(Player playerGuesser) {
        this.playerGuesser = playerGuesser;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }
}
