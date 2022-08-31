package com.ProjectGames.DTO;

import com.ProjectGames.model.Player;
import com.ProjectGames.model.TypePlayer;

public class PlayerDTO {

    private int id;
    private String username;
    private TypePlayer typePlayer;
    private int age;

    public PlayerDTO(int id, String username, TypePlayer typePlayer, int age){
        this.id = id;
        this.username = username;
        this.typePlayer = typePlayer;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public TypePlayer getTypePlayer() {
        return typePlayer;
    }

    public void setTypePlayer(TypePlayer typePlayer) {
        this.typePlayer = typePlayer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
