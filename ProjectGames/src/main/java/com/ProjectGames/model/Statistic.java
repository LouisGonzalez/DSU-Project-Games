package com.ProjectGames.model;

public class Statistic {

    private StatisticValue value;
    private TypeGame typeGame;

    public Statistic(StatisticValue value, TypeGame typeGame){
        this.value = value;
        this.typeGame = typeGame;
    }

    public StatisticValue getValue() {
        return value;
    }

    public void setValue(StatisticValue value) {
        this.value = value;
    }

    public TypeGame getTypeGame() {
        return typeGame;
    }

    public void setTypeGame(TypeGame typeGame) {
        this.typeGame = typeGame;
    }
}
