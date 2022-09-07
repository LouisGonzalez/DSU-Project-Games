package com.ProjectGames.service.hangman;

import com.ProjectGames.DTO.GameDataDTO;
import com.ProjectGames.DTO.PlayerDTO;
import com.ProjectGames.model.Player;
import com.ProjectGames.model.Principal;
import com.ProjectGames.model.TypeGame;
import com.ProjectGames.model.hangman.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HangmanService {

    public List<GameDataDTO> findAllGames(){
        List<GameDataDTO> listGames = new ArrayList<>();
        for (int i = 0; i < Principal.games.size(); i++) {
            if(Principal.games.get(i).getTypeGame() == TypeGame.HANGMAN) {
                Hangman game = (Hangman) Principal.games.get(i);
                Player playerGiver = game.getPlayerGiver();
                Player playerGuesser = game.getPlayerGuesser();
                PlayerDTO playerGiversend = new PlayerDTO(game.getIdPlayers().get(0), playerGiver.getName(), playerGiver.getTypePlayer(), playerGiver.getAge());
                PlayerDTO playerGuessersend = new PlayerDTO(game.getIdPlayers().get(1), playerGuesser.getName(), playerGuesser.getTypePlayer(), playerGiver.getAge());
                GameDataDTO gameDTO = new GameDataDTO(i, game.getCountMoves(), playerGiversend, playerGuessersend);
                listGames.add(gameDTO);
            }
        }
        return listGames;
    }

    public GameDataDTO findDataGame(Long idGame){
        Hangman game = (Hangman) Principal.games.get(idGame.intValue());
        Player playerGiver = game.getplayerGiver();
        Player playerGuesser = game.getplayerGuesser();
        PlayerDTO playerGiversend = new PlayerDTO(game.getIdPlayers().get(0), playerGiver.getName(), playerGiver.getTypePlayer(), playerGiver.getAge());
        PlayerDTO playerGuessersend = new PlayerDTO(game.getIdPlayers().get(1), playerGuesser.getName(), playerGuesser.getTypePlayer(), playerGiver.getAge());
        GameDataDTO gameSend = new GameDataDTO(game.getCountMoves(), playerGiversend, playerGuessersend);
        return gameSend;
    }


	
	public void setSecretWord(Stirng sWord, String guessingWord){
		
	  for (int i = 0;i < sWord.length; i++){
	    guessingWord += "_ ";
	  }
	   
	}
	
	public String array2String(array){
	  String array2String = "";
	  for (int i = 0; i < array.length; i++){
	    array2String += array[i];
	  }
	  return array2String;
	}
	
	public void checkLetter(String guessingWord, String sWord){
	 String[] tempguessingWord = guessingWord.split(""); 
	 String[] tempsecretWord = sWord.split(""); 
	
	  if (ifExists(sWord, keyRead)){
	    for (var i = 0; i < sWord.length; i++){
	      if (tempsecretWord[i] == keyRead) tempguessingWord[i*2] = keyRead;
	    }
	    guessingWord = array2String(tempguessingWord);
	  }
	}
	
	public boolean checkWin(Board board, String guessingWord, String sWord){
	  String temp = array2String(guessingWord.split(" "));
	  return (temp == sWord);
}


}
