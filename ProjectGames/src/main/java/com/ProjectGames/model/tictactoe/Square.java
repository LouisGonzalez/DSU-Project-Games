package com.ProjectGames.model.tictactoe;

public class Square {

    ValueSquare myValue;

    public Square(){
        this.myValue = ValueSquare.EMPTY;
    }

    public void setMyValue(ValueSquare myValue){
        this.myValue = myValue;
    }

    public ValueSquare getMyValue(){
        return this.myValue;
    }

}
