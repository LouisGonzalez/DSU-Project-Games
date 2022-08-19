package com.ProjectGames.model.tictactoe;

import com.ProjectGames.model.Game;

import java.util.ArrayList;

public class MovementGame {

    private int idGame;
    private int posX;
    private int posY;
    private Coin coinMove;

    public MovementGame(int idGame, int posX, int posY, String coinMove){
        this.idGame = idGame;
        this.posX = posX;
        this.posY = posY;
        this.determinateCoin(coinMove);
    }

    public void determinateCoin(String coin){
        if(coin.equals("X"))
            this.coinMove = new Coin(ValueCoin.X);
        else if(coin.equals("O"))
            this.coinMove = new Coin(ValueCoin.O);
    }

    //ESTO VA EN EL CONTROLADOR
    /*public static Game findGame(ArrayList<Game> listGames){
        for (Game game: listGames) {

        }
    }*/


}
