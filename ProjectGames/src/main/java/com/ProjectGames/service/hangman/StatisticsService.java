package com.ProjectGames.service.hangman;

import com.ProjectGames.model.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    public void saveWinnerAndLosser(ObjectNode move, String secretWord, String guessingWord){
        if(secretWord != guessingWord) {
            saveGameResult(move.get("idPlayerGiver").asInt(), StatisticValue.WIN);
            saveGameResult(move.get("idPlayerGuesser").asInt(), StatisticValue.LOSE);
        } else {
            saveGameResult(move.get("idPlayerGiver").asInt(), StatisticValue.LOSE);
            saveGameResult(move.get("idPlayerGuesser").asInt(), StatisticValue.WIN);
        }
    }
    
    public void saveGameResult(int idPlayer, StatisticValue value){
        Player player = findPlayer(idPlayer);
        player.getMyStatistics().getListStatistics().add(new Statistic(value, TypeGame.HANGMAN));
    }

    public Player findPlayer(int idPlayer){
        return Principal.players.get(idPlayer);
    }

}
