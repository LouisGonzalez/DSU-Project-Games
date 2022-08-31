package com.ProjectGames.model.tictactoe;

import com.ProjectGames.model.Game;

import java.util.ArrayList;

public class MovementGame {

    private int idGame;
    private int posX;
    private int posY;
    private Coin coinMove;
    private String coin;
    private int player;

    public MovementGame(int idGame, int posX, int posY, String coin, int player){
        this.idGame = idGame;
        this.posX = posX;
        this.posY = posY;
        this.player = player;
        this.coin = coin;
        this.determinateCoin(coin);
    }

    public MovementGame(int idGame, int posX, int posY, String coin){
        this.idGame = idGame;
        this.posX = posX;
        this.posY = posY;
        this.coin = coin;
        this.determinateCoin(coin);
    }

    public void determinateCoin(String coin){
        if(coin.equals("x"))
            this.coinMove = new Coin(ValueCoin.X);
        else if(coin.equals("o"))
            this.coinMove = new Coin(ValueCoin.O);
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Coin getCoinMove() {
        return coinMove;
    }

    public void setCoinMove(Coin coinMove) {
        this.coinMove = coinMove;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }
//ESTO VA EN EL CONTROLADOR
    /*public static Game findGame(ArrayList<Game> listGames){
        for (Game game: listGames) {

        }
    }*/


}
