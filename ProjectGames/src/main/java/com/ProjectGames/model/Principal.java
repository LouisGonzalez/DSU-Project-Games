package com.ProjectGames.model;

import com.ProjectGames.model.tictactoe.MovementGame;
import com.ProjectGames.service.TictactoeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Principal implements TictactoeService {

    public static ArrayList<Game> games = new ArrayList<>();
    public static ArrayList<Player> players = new ArrayList<>();
    public static ArrayList<MovementGame> moves = new ArrayList<>();

    public ArrayList<Game> getGames(){
        return this.games;
    }

    public void setGames(ArrayList<Game> games){
        this.games = games;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void setPlayers(ArrayList<Player> players) {
        Principal.players = players;
    }

    public static ArrayList<MovementGame> getMoves() {
        return moves;
    }

    public static void setMoves(ArrayList<MovementGame> moves) {
        Principal.moves = moves;
    }
}