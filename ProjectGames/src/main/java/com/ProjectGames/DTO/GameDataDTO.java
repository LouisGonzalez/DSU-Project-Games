package com.ProjectGames.DTO;

import com.ProjectGames.model.Player;

public class GameDataDTO {

    private int idGame;
    private int countMoves;
    private PlayerDTO playerX;
    private PlayerDTO playerO;

    private PlayerDTO playerGiver;
    private PlayerDTO playerGuesser;
    private int remainingAttempts;

    public GameDataDTO(int countMoves, PlayerDTO playerX, PlayerDTO playerO){
        this.countMoves = countMoves;
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public GameDataDTO(int idGame, int countMoves, PlayerDTO playerX, PlayerDTO playerO){
        this.countMoves = countMoves;
        this.playerX = playerX;
        this.playerO = playerO;
        this.idGame = idGame;
    }

    public GameDataDTOhm(int countMoves, PlayerDTO playerGiver, PlayerDTO playerGuesser){
        this.countMoves = countMoves;
        this.playerGiver = playerGiver;
        this.playerGuesser = playerGuesser;
    }

    public GameDataDTOhm(int idGame, int countMoves, PlayerDTO playerGiver, PlayerDTO playerGuesser){
        this.countMoves = countMoves;
        this.playerGiver = playerGiver;
        this.playerGuesser = playerGuesser;
        this.idGame = idGame;
    }
    
    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getCountMoves() {
        return countMoves;
    }

    public void setCountMoves(int countMoves) {
        this.countMoves = countMoves;
    }
    
    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public void setRemainingAttempts(int remainingAttempts) {
        this.remainingAttempts = remainingAttempts;
    }

    public PlayerDTO getPlayerX() {
        return playerX;
    }

    public void setPlayerX(PlayerDTO playerX) {
        this.playerX = playerX;
    }

    public PlayerDTO getPlayerO() {
        return playerO;
    }

    public void setPlayerO(PlayerDTO playerO) {
        this.playerO = playerO;
    }
    
    public PlayerDTO getPlayerGiver() {
        return playerGiver;
    }

    public void setPlayerGiver(PlayerDTO playerGiver) {
        this.playerGiver = playerGiver;
    }

    public PlayerDTO getPlayerGuesser() {
        return playerGuesser;
    }

    public void setPlayerGuesser(PlayerDTO playerGuesser) {
        this.playerGuesser = playerGuesser;
    }
}
