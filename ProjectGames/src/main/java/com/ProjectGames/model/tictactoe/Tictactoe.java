package com.ProjectGames.model.tictactoe;

import com.ProjectGames.controller.IPlayerGeneral;
import com.ProjectGames.model.Game;
import com.ProjectGames.model.Player;

import java.util.ArrayList;

public class Tictactoe extends Game {
    private int idGame;
    private Board myBoard;
    private Player playerX;
    private Player playerO;
    public Tictactoe(ArrayList<Integer> idPlayers, int idGame){
        super(idPlayers);
        this.myBoard = new Board();
        this.idGame = idGame;
        this.initPlayers();
    }

    public void initPlayers(){
        this.selectPlayers(this.listProviders);
        playerX = this.players.get(0);
        playerO = this.players.get(1);
    }

    public void setMyBoard(Board myBoard){
        this.myBoard = myBoard;
    }

    public Board getMyBoard(){
        return this.myBoard;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public void setPlayerX(Player playerX) {
        this.playerX = playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

    public void setPlayerO(Player playerO) {
        this.playerO = playerO;
    }
}
