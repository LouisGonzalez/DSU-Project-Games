package com.ProjectGames.controller.hangman;

import com.ProjectGames.model.Principal;
import com.ProjectGames.model.StatisticValue;
import com.ProjectGames.model.hangman.MovementGame;
import com.ProjectGames.model.hangman.Hangman;
import com.ProjectGames.service.hangman.StatisticsService;
import com.ProjectGames.service.hangman.HangmanService;
import com.ProjectGames.service.hangman.MovementService;
import com.ProjectGames.source.Constants;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = Constants.URL_FRONT_END, allowCredentials = "true")
@RestController
@RequestMapping(Constants.API_V1 + "/hangman/move")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @Autowired
    private StatisticsService statisticsService;

    @PostMapping("/")
    public ResponseEntity<MovementGame> add(@RequestBody ObjectNode move){
        try {
            MovementGame newMove = new MovementGame(move.get("idGame").asInt(), move.get("guessingLetter").asText(), move.get("guessedLetters").asText(), move.get("remainingAttempts").asInt(), move.get("sWord").asText(), move.get("guessingWord").asText(), move.get("player").asInt());
            Principal.moves.add(newMove);
            boolean finished = movementService.putMoveInBoard(newMove.getIdGame(), newMove.getguessingLetter(), newMove.getguessedLetters(), newMove.getremainingAttempts(), newMove.getsWord(), newMove.getguessingWord());
            System.out.println(finished);
            if(finished){
                System.out.println("Game Over");
                statisticsService.saveWinnerAndLosser(move, newMove.getsWord(), newMove.getguessingWord());
                return new ResponseEntity("Game Over", HttpStatus.OK);
            }
            System.out.println("Move added");
            return new ResponseEntity("Move added", HttpStatus.OK);
        } catch(Exception e){
            return ResponseEntity.badRequest().build(); //404 bad request
        }
    }


}
