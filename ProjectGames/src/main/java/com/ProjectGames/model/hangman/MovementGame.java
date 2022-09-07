package com.ProjectGames.model.hangman;

import com.ProjectGames.model.Game;

import java.util.ArrayList;

public class MovementGame {

    private int idGame;
    private String guessingLetter;
    private String guessedLetters;
    private String sWord;
    private String guessingWord;
    private int remainingAttempts;
    private int player;


    public MovementGame(int idGame, String guessingLetter, String guessedLetters, int remainingAttempts, String sWord, String guessingWord, int player){
        this.idGame = idGame;
        this.guessingLetter = guessingLetter;
        this.guessedLetters = guessedLetters;
        this.remainingAttempts = remainingAttempts;
        this.sWord = sWord;
        this.guessingWord = guessingWord;
        this.player = player;
    }

    public MovementGame(int idGame, String guessingLetter, String guessedLetters, int remainingAttempts, int remainingAttempts, String sWord, String guessingWord){
        this.idGame = idGame;
        this.guessingLetter = guessingLetter;
        this.guessedLetters = guessedLetters;
        this.remainingAttempts = remainingAttempts;
        this.sWord = sWord;
        this.guessingWord = guessingWord;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }
    
    public int getIdGame() {
        return idGame;
    }

    public String getguessingLetter() {
        return guessingLetter;
    }

    public String getguessedLetters() {
        return guessedLetters;
    }

    public int getremainingAttempts() {
        return remainingAttempts;
    }

    public String getsWord() {
        return sWord;
    }
    
    public int getguessingWord() {
        return guessingWord;
    }

}
