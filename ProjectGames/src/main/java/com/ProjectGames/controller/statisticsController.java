package com.ProjectGames.controller;

import com.ProjectGames.model.Player;
import com.ProjectGames.model.Statistic;
import com.ProjectGames.model.TypeGame;
import com.ProjectGames.service.tictactoe.StatisticsService;
import com.ProjectGames.source.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constants.API_V1 + "/statistics")
public class statisticsController {
        @Autowired
        private StatisticsService statisticService;
        TypeGame typeGame;

    @CrossOrigin(origins = "*")
        @GetMapping("/StatisticList")
        public ResponseEntity <ArrayList<Player>> getStatistics(){
            return ResponseEntity.ok(statisticService.showStatistics());
        }

    @CrossOrigin(origins = "*")
    @GetMapping("/statistics-tictactoe")
    public ResponseEntity<ArrayList<Player>> getStatisticsByTypeGame(){
            /*if(name.equalsIgnoreCase("HangMan")){
                typeGame = TypeGame.HANGMAN;
            }else if(name.equalsIgnoreCase("Tictactoe")){
                typeGame = TypeGame.TICTACTOE;
            }*/
        return ResponseEntity.ok(statisticService.showStatistics());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/statistics-hangman")
    public ResponseEntity<ArrayList<Player>> getStatisticsByHangman(){
            /*if(name.equalsIgnoreCase("HangMan")){
                typeGame = TypeGame.HANGMAN;
            }else if(name.equalsIgnoreCase("Tictactoe")){
                typeGame = TypeGame.TICTACTOE;
            }*/
        return ResponseEntity.ok(statisticService.showStatistics());
    }

}
