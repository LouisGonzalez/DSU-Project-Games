package com.ProjectGames.service.tictactoe;

import com.ProjectGames.model.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    public static ArrayList<Statistic> statistics = new ArrayList<>();

    public ArrayList<Player> showStatistics(){
        /*ArrayList<Statistic> stats = new ArrayList<>();
        for (int i = 0; i<statistics.size(); i++){
            stats.add(statistics.get(i)) ;
        }*/
        return Principal.players;
    }

    public ArrayList<Statistic> StatisticsByGame(TypeGame type){
        ArrayList<Statistic> stats = new ArrayList<>();
        for (Statistic statistic : statistics) {
            if (statistic.getTypeGame() == type) {
                stats.add(statistic);
            }
        }
        return stats;
    }

}
