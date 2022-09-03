package com.ProjectGames.service;

import com.ProjectGames.model.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class statisticsService {

        public static ArrayList<Statistic> statistics = new ArrayList<>();

        public ArrayList<Statistic> showStatistics(){
            ArrayList<Statistic> stats = new ArrayList<>();
        for (int i = 0; i<statistics.size(); i++){
            stats.add(statistics.get(i)) ;
        }
        return stats;
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
