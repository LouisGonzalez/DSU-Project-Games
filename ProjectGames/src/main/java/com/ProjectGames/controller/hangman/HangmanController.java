package com.ProjectGames.controller.hangman;

import com.ProjectGames.DTO.GameDataDTO;
import com.ProjectGames.DTO.IdGameDTO;
import com.ProjectGames.model.Game;
import com.ProjectGames.model.Principal;
import com.ProjectGames.model.StatisticValue;
import com.ProjectGames.model.TypeGame;
import com.ProjectGames.model.hangman.MovementGame;
import com.ProjectGames.model.hangman.Hangman;
import com.ProjectGames.service.hangman.StatisticsService;
import com.ProjectGames.service.hangman.HangmanService;
import com.ProjectGames.source.Constants;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.coyote.Response;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin (origins = Constants.URL_FRONT_END, allowCredentials = "true")
@RestController
@RequestMapping (Constants.API_V1 + "/game/hangman")
public class HangmanController {

    @Autowired
    private HangmanService hmService;

    @Autowired
    private StatisticsService statisticsService;


    @PostMapping("/")
    public ResponseEntity<Hangman> add(@RequestBody ObjectNode game){
        try {
            ArrayList<Integer> idPlayers = new ArrayList<>();
            idPlayers.add(game.get("playerGiver").asInt());
            idPlayers.add(game.get("playerGuesser").asInt());
            int idGame = Principal.games.size();
            Hangman hm = new Hangman(idPlayers, idGame, TypeGame.HANGMAN);
            Principal.games.add(hm);
            System.out.println("Game created");
            return new ResponseEntity("Game created", HttpStatus.OK);
        } catch(Exception e){
            return ResponseEntity.badRequest().build(); //404 bad request
        }
    }

    @PostMapping("/count-moves/")
    public ResponseEntity<Hangman> updateCountMoves(@RequestBody ObjectNode node){
        try {
            int countMoves = node.get("countMoves").asInt();
            Game actualGame = Principal.games.get(node.get("game").asInt());
            actualGame.setCountMoves(countMoves);            
            return new ResponseEntity("change added", HttpStatus.OK);
        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/remaining-attempts/")
    public ResponseEntity<Hangman> updateRemainingAttempts(@RequestBody ObjectNode node){
        try {
            int remainingAttempts = node.get("remainingAttempts").asInt();
            Game actualGame = Principal.games.get(node.get("game").asInt());
            actualGame.setRemainingAttempts(remainingAttempts);
            boolean fullSpaces = hangmanService.isEmptySpaces(actualGame.getCountMoves());
            if(remainingAttempts == 0){
                statisticsService.saveGameResult(node.get("idPlayerGiver").asInt(), StatisticValue.WIN);
                statisticsService.saveGameResult(node.get("idPlayerGuesser").asInt(), StatisticValue.LOSE);
                return new ResponseEntity("DRAW", HttpStatus.OK);
            }
            return new ResponseEntity("change added", HttpStatus.OK);
        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value="/data/{idGame}")
    public ResponseEntity<GameDataDTO> getDataGame(@PathVariable Long idGame){
        return ResponseEntity.ok(hmService.findDataGame(idGame));
    }

    @GetMapping(value="/id")
    public ResponseEntity<IdGameDTO> getIdGame(){
        Hangman game= (Hangman) Principal.games.get(Principal.games.size()-1);
        IdGameDTO gameInfo = new IdGameDTO(game.getIdGame());
        return ResponseEntity.ok(gameInfo);
    }

    @GetMapping(value="/all")
    public ResponseEntity<List<GameDataDTO>> getAllGames(){
        return ResponseEntity.ok(hmService.findAllGames());
    }


}
