package com.ProjectGames.model;


public class Player {

    private int id;
    private String name;
    private int age;

    private TypePlayer typePlayer;
    private StatisticsPlayer myStatistics = new StatisticsPlayer();

    public Player(String name, String type, int id, int age){
        this.id = id;
        this.name = name;
        this.age = age;
        this.typePlayer = defineTypePlayer(type);
    }

    private TypePlayer defineTypePlayer(String type){
        if(type.equals("Human")){
            return TypePlayer.HUMAN;
        } else if(type.equals("Bot")){
            return TypePlayer.BOT;
        }
        return null;
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

    public TypePlayer getTypePlayer() {
        return typePlayer;
    }

    public void setTypePlayer(TypePlayer typePlayer) {
        this.typePlayer = typePlayer;
    }

    public StatisticsPlayer getMyStatistics() {
        return myStatistics;
    }

    public void setMyStatistics(StatisticsPlayer myStatistics) {
        this.myStatistics = myStatistics;
    }

}
