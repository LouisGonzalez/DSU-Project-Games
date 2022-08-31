package com.ProjectGames.controller.tictactoe;

import com.ProjectGames.model.Principal;
import com.ProjectGames.model.StatisticValue;
import com.ProjectGames.model.tictactoe.MovementGame;
import com.ProjectGames.model.tictactoe.Tictactoe;
import com.ProjectGames.service.tictactoe.StatisticsService;
import com.ProjectGames.service.tictactoe.TictactoeService;
import com.ProjectGames.service.tictactoe.MovementService;
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
@RequestMapping(Constants.API_V1 + "/tictactoe/move")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @Autowired
    private StatisticsService statisticsService;

    @PostMapping("/")
    public ResponseEntity<MovementGame> add(@RequestBody ObjectNode move){
        try {
            MovementGame newMove = new MovementGame(move.get("idGame").asInt(), move.get("posX").asInt(), move.get("posY").asInt(), move.get("coin").asText(), move.get("player").asInt());
            Principal.moves.add(newMove);
            boolean finished = movementService.putMoveInBoard(newMove.getIdGame(), newMove.getPosX(), newMove.getPosY(), newMove.getCoin());
            System.out.println(finished);
            if(finished){
                System.out.println("the game is over");
                statisticsService.saveWinnerAndLosser(move, newMove.getCoin());
                return new ResponseEntity("The game is over", HttpStatus.OK);
            }
            System.out.println("Move added");
            return new ResponseEntity("Move added", HttpStatus.OK);
        } catch(Exception e){
            return ResponseEntity.badRequest().build(); //404 bad request
        }
    }


}
