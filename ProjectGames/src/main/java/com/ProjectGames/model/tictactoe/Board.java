package com.ProjectGames.model.tictactoe;

public class Board {

    public final int BOARD_SIZE = 3;
    private Square[][] board = new Square[BOARD_SIZE][BOARD_SIZE];

    public Board(){
        initValues();
    }

    public void initValues(){
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new Square();
            }
        }
    }

    public void setBoard(Square[][] board){
        this.board = board;
    }

    public Square[][] getBoard(){
        return this.board;
    }

}
