package com.ProjectGames.model;


public class Player {

    private int id;
    private String name;
    private int age;

    private StatisticsPlayer myStatistics = new StatisticsPlayer();


    public Player(String name, int age, int id){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
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
