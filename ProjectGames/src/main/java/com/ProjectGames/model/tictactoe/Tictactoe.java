package com.ProjectGames.model.tictactoe;

import com.ProjectGames.controller.IPlayerGeneral;
import com.ProjectGames.model.Game;
import com.ProjectGames.model.Player;

import java.util.ArrayList;

public class Tictactoe extends Game {
    private Board myBoard;
    private Player playerX;
    private Player playerO;

    public Tictactoe(ArrayList<IPlayerGeneral> generalList, int totalPlayers, Player playerX, Player playerO){
        super(generalList, totalPlayers);
        myBoard = new Board();
        this.playerO = playerO;
        this.playerX = playerX;
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
