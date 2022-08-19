package com.ProjectGames.model;

public class Player {

    private String name;
    private StatisticsPlayer myStatistics = new StatisticsPlayer();

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatisticsPlayer getMyStatistics() {
        return myStatistics;
    }

    public void setMyStatistics(StatisticsPlayer myStatistics) {
        this.myStatistics = myStatistics;
    }


}
