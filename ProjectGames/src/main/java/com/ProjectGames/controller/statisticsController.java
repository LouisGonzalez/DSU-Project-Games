package com.ProjectGames.controller;

import com.ProjectGames.model.Statistic;
import com.ProjectGames.model.TypeGame;
import com.ProjectGames.model.tictactoe.Tictactoe;
import com.ProjectGames.service.statisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class statisticsController {
        @Autowired
        statisticsService statisticService;
        TypeGame typeGame;

    @CrossOrigin(origins = "*")
        @GetMapping("/StatisticList")
        public ResponseEntity <ArrayList<Statistic>> getStatistics(){
            return ResponseEntity.ok(statisticService.showStatistics());
        }

    @CrossOrigin(origins = "*")
        @GetMapping("/StatisticsByGame/{name}")
        public ArrayList<Statistic> getStatisticsByTypeGame(@PathVariable String name){
            if(name.equalsIgnoreCase("HangMan")){
                typeGame = TypeGame.HANGMAN;
            }else if(name.equalsIgnoreCase("Tictactoe")){
                typeGame = TypeGame.TICTACTOE;
            }
            return statisticService.StatisticsByGame(typeGame);
        }

    }
