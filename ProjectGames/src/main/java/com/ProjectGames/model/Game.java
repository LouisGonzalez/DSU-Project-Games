package com.ProjectGames.model;

import com.ProjectGames.controller.GamePlayersProvider;
import com.ProjectGames.controller.IPlayerGeneral;
import com.ProjectGames.controller.ListPlayersController;
import com.ProjectGames.controller.tictactoe.ITTTPlayer;
import com.ProjectGames.model.tictactoe.Board;

import java.util.ArrayList;

public abstract class Game {


    private boolean finished;
    private int guessingAttemps;
    private int countMoves;
    public ArrayList<Player> players;
    private ArrayList<Integer> idPlayers;
    private int totalPlayers;
    public GamePlayersProvider listProviders;

    private TypeGame typeGame;


    public Game(ArrayList<Integer> idPlayers, TypeGame typeGame) {

            this.listProviders = new ListPlayersController();
            this.finished = false;
            this.guessingAttemps = 0;
            this.countMoves = 0;
            this.idPlayers = idPlayers;
            this.typeGame = typeGame;

        }

        public void selectPlayers (GamePlayersProvider listProviders){
            this.players = listProviders.getPlayersGeneralList(idPlayers);
        }

        public void setFinished ( boolean finished){
            this.finished = finished;
        }

        public boolean getFinished () {
            return this.finished;
        }

        public void setGuessingAttemps ( int guessingAttemps){
            this.guessingAttemps = guessingAttemps;
        }

        public int getGuessingAttemps () {
            return this.guessingAttemps;
        }

        public int getCountMoves () {
            return countMoves;
        }

        public boolean isFinished () {
            return finished;
        }

        public ArrayList<Player> getPlayers () {
            return players;
        }

        public void setPlayers (ArrayList < Player > players) {
            this.players = players;
        }

        public ArrayList<Integer> getIdPlayers () {
            return idPlayers;
        }

        public void setIdPlayers (ArrayList < Integer > idPlayers) {
            this.idPlayers = idPlayers;
        }

        public int getTotalPlayers () {
            return totalPlayers;
        }

        public void setTotalPlayers ( int totalPlayers){
            this.totalPlayers = totalPlayers;
        }

        public GamePlayersProvider getListProviders () {
            return listProviders;
        }

        public void setListProviders (GamePlayersProvider listProviders){
            this.listProviders = listProviders;
        }

        public void setCountMoves ( int countMoves){
            this.countMoves = countMoves;
        }


        public TypeGame getTypeGame () {
            return typeGame;
        }

        public void setTypeGame (TypeGame typeGame){
            this.typeGame = typeGame;
        }
    }

