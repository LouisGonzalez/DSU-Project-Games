package com.ProjectGames.model.tictactoe;

public class Board {

    private final int BOARD_SIZE = 3;
    private Square[][] board = new Square[BOARD_SIZE][BOARD_SIZE];

    public void setMyBoard(Square[][] board){
        this.board = board;
    }

    public Square[][] getMyBoard(){
        return this.board;
    }

}
