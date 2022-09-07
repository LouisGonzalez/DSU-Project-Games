package com.ProjectGames.service.hangman;

import com.ProjectGames.model.Principal;
import com.ProjectGames.model.hangman.Hangman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementService {

    @Autowired
    private HangmanService hangmanService;

    public boolean putMoveInBoard(int idGame, String guessingLetter, String guessedLetters, int remainingAttempts, String sWord, String guessingWord){
        System.out.println("Entro aqui");
        Hangman game = (Hangman) Principal.games.get(idGame);
        game.getMyBoard().setsecretWord(secretWord);
        game.getMyBoard().setguessedLetters(guessedLetters);
        game.getMyBoard().setguessingLetter(guessingLetter);
        game.getMyBoard().setremainingAttempts(remainingAttempts);
        return hangmanService.checkWin(game.getMyBoard(), guessingWord, sWord);
        
    }

}