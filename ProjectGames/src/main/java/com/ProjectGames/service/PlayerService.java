package com.ProjectGames.service;

import com.ProjectGames.model.Player;
import com.ProjectGames.model.Principal;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    public boolean exists(String username){
        for (Player player: Principal.players) {
            if(username.equals(player.getName())){
                return true;
            }
        }
        return false;
    }

}
