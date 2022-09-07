package com.ProjectGames.model.hangman;

public class SecretWord {
	
    private String secretWord;
    
    public SecretWord(String secretWord){
        this.secretWord = secretWord;
    }

    public String getsecretWord() {
        return secretWord;
    }

    public void setsecretWord(String secretWord) {
        this.secretWord = secretWord;
    }
 
}
