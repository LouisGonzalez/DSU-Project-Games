package com.ProjectGames.controller;

import java.util.ArrayList;
import com.ProjectGames.DTO.PlayerDTO;
import com.ProjectGames.model.Player;
import com.ProjectGames.model.Principal;
import com.ProjectGames.service.PlayerService;
import com.ProjectGames.source.Constants;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.ProjectGames.model.Player;
import com.ProjectGames.model.TypePlayer;
import com.ProjectGames.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all/")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers(){
        return ResponseEntity.ok(playerService.findPlayersInfo());
    }



    @GetMapping("/playerList")
        public ResponseEntity <ArrayList<Player>> ShowPlayers(){
            return ResponseEntity.ok(playerService.ShowPlayers());
        }


    @GetMapping("/searchPlayer/{name}")
    public ResponseEntity<Player> readPlayer(@PathVariable String name){
        try{
            Player player = playerService.readPlayer(name);
            return player != null ?
                    ResponseEntity.ok(player):
                    ResponseEntity.notFound()
                            .header("Error", "Player name not found")
                            .build();
        }catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/getPlayerById/{id}")
    public ResponseEntity<Player> getOne(@PathVariable int id){
        Player player = playerService.getOne(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }


    /*@PutMapping("/updatePlayer")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player p){
        playerService.updatePlayer(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }*/

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Player> removePlayer(@PathVariable int id){
        Player player = playerService.removePlayer(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
}
