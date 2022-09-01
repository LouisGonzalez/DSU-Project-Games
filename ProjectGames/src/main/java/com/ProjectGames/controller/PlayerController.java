package com.ProjectGames.controller;

import com.ProjectGames.model.Player;
import com.ProjectGames.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "*")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @CrossOrigin(origins = "*")
    @GetMapping("/playerList")
        public ResponseEntity <ArrayList<Player>> ShowPlayers(){
            return ResponseEntity.ok(playerService.ShowPlayers());
        }

    @CrossOrigin(origins = "*")
    @PostMapping("/addPlayer")
    public ResponseEntity<Player> createPlayer(@RequestBody Player p){
        String name = p.getName();
        int id = p.getid();
        int age =p.getAge();
        playerService.createPlayer(name,age,id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
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
    @CrossOrigin(origins = "*")
    @GetMapping("/getPlayerById/{id}")
    public ResponseEntity<Player> getOne(@PathVariable int id){
        Player player = playerService.getOne(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/updatePlayer")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player p){
        playerService.updatePlayer(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Player> removePlayer(@PathVariable int id){
        Player player = playerService.removePlayer(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
}
