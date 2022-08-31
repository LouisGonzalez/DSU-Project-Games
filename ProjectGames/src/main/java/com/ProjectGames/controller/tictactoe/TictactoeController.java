package com.ProjectGames.controller.tictactoe;

import com.ProjectGames.DTO.GameDataDTO;
import com.ProjectGames.model.Game;
import com.ProjectGames.model.Principal;
import com.ProjectGames.model.StatisticValue;
import com.ProjectGames.model.tictactoe.MovementGame;
import com.ProjectGames.model.tictactoe.Tictactoe;
import com.ProjectGames.service.tictactoe.StatisticsService;
import com.ProjectGames.service.tictactoe.TictactoeService;
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
@RequestMapping (Constants.API_V1 + "/game/tictactoe")
public class TictactoeController {

    @Autowired
    private TictactoeService tttService;

    @Autowired
    private StatisticsService statisticsService;


    @PostMapping("/")
    public ResponseEntity<Tictactoe> add(@RequestBody ObjectNode game){
        try {
            ArrayList<Integer> idPlayers = new ArrayList<>();
            idPlayers.add(game.get("playerX").asInt());
            idPlayers.add(game.get("playerO").asInt());
            Tictactoe ttt = new Tictactoe(idPlayers, game.get("idGame").asInt());
            Principal.games.add(ttt);
            System.out.println("Game created");
            return new ResponseEntity("Game created", HttpStatus.OK);
        } catch(Exception e){
            return ResponseEntity.badRequest().build(); //404 bad request
        }
    }

    @PostMapping("/count-moves/")
    public ResponseEntity<Tictactoe> updateCountMoves(@RequestBody ObjectNode node){
        try {
            int countMoves = node.get("countMoves").asInt();
            Game actualGame = Principal.games.get(node.get("game").asInt());
            actualGame.setCountMoves(countMoves);
            boolean fullSpaces = tttService.isEmptySpaces(actualGame.getCountMoves());
            if(fullSpaces){
                statisticsService.saveGameResult(node.get("idPlayerX").asInt(), StatisticValue.DRAW);
                statisticsService.saveGameResult(node.get("idPlayerO").asInt(), StatisticValue.DRAW);
                return new ResponseEntity("DRAW", HttpStatus.OK);
            }
            return new ResponseEntity("change added", HttpStatus.OK);
        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value="/{idGame}")
    public ResponseEntity<List<MovementGame>> getAllSquares(@PathVariable Long idGame){
        return ResponseEntity.ok(tttService.findAllSquares(idGame));
    }

    @GetMapping(value="/data/{idGame}")
    public ResponseEntity<GameDataDTO> getDataGame(@PathVariable Long idGame){
        return ResponseEntity.ok(tttService.findDataGame(idGame));
    }



}
