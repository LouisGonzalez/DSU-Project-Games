package com.ProjectGames.model;
import com.ProjectGames.controller.IPlayerGeneral;
import java.util.ArrayList;

public class Menu {

    private ArrayList<IPlayerGeneral> listPlayers = new ArrayList<>();

    public ArrayList<IPlayerGeneral> getListPlayers() {
        return listPlayers;
    }

    public void setListPlayers(ArrayList<IPlayerGeneral> listPlayers) {
        this.listPlayers = listPlayers;
    }

}
