package com.ProjectGames.model.tictactoe;

public class Coin {

    private ValueCoin myCoin;

    public Coin(ValueCoin myCoin){
        this.myCoin = myCoin;
    }

    public ValueCoin getMyCoin() {
        return myCoin;
    }

    public void setMyCoin(ValueCoin myCoin) {
        this.myCoin = myCoin;
    }
}
