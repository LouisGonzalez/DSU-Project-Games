package com.ProjectGames.service.tictactoe;

import com.ProjectGames.model.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {


    public void saveWinnerAndLosser(ObjectNode move, String coin){
        if(coin.equals("x")) {
            saveGameResult(move.get("idPlayerX").asInt(), StatisticValue.WIN);
            saveGameResult(move.get("idPlayerO").asInt(), StatisticValue.LOSE);
        } else if(coin.equals("o")){
            saveGameResult(move.get("idPlayerX").asInt(), StatisticValue.LOSE);
            saveGameResult(move.get("idPlayerO").asInt(), StatisticValue.WIN);
        }
    }
    public void saveGameResult(int idPlayer, StatisticValue value){
        Player player = findPlayer(idPlayer);
        player.getMyStatistics().getListStatistics().add(new Statistic(value, TypeGame.TICTACTOE));
    }

    public Player findPlayer(int idPlayer){
        return Principal.players.get(idPlayer);
    }

}
