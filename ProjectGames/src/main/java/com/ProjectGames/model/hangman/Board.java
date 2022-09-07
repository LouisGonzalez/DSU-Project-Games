package com.ProjectGames.model.hangman;

public class Board {

	public int guessingAttempts;
	public String sWord;
	public String guessingLetter;
	public String guessedLetters;
    

    public Board(){
        initValues();
    }

    public void initValues(){
    	guessingAttempts = 8;
    	sWord = "";
    	guessingLetter = "";
    	guessedLetters = "";
    }

    public void setBoard(board){
        this.board = board;
    }
    
    public void setguessingLetter(guessingLetter){
        this.guessingLetter = guessingLetter;
    }

    public void setguessedLetters(guessedLetters){
        this.guessedLetters = guessedLetters;
    }
    
    public void setsecretWord(secretWord){
        this.secretWord = secretWord;
    }

}
