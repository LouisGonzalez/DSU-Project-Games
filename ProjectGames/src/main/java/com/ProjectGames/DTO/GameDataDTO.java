package com.ProjectGames.DTO;

import com.ProjectGames.model.Player;

public class GameDataDTO {
    private int countMoves;
    private PlayerDTO playerX;
    private PlayerDTO playerO;

    public GameDataDTO(int countMoves, PlayerDTO playerX, PlayerDTO playerO){
        this.countMoves = countMoves;
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public int getCountMoves() {
        return countMoves;
    }

    public void setCountMoves(int countMoves) {
        this.countMoves = countMoves;
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
}
