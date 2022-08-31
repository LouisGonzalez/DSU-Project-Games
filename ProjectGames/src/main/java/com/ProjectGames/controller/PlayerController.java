package com.ProjectGames.controller;

import com.ProjectGames.model.Player;
import com.ProjectGames.model.Principal;
import com.ProjectGames.service.PlayerService;
import com.ProjectGames.source.Constants;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin (origins = Constants.URL_FRONT_END, allowCredentials = "true")
@RestController
@RequestMapping(Constants.API_V1 + "/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/")
    public ResponseEntity<Player> add(@RequestBody ObjectNode player){
        try {
            if(playerService.exists(player.get("username").asText()))
                return new ResponseEntity("Player already exists", HttpStatus.BAD_REQUEST);
            Player newPlayer = new Player(player.get("username").asText(), player.get("age").asInt(), player.get("typePlayer").asText());
            Principal.players.add(newPlayer);
            System.out.println("Player added");
            return new ResponseEntity("Player added", HttpStatus.OK);
        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
