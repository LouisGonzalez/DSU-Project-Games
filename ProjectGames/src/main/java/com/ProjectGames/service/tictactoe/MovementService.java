package com.ProjectGames.service.tictactoe;

import com.ProjectGames.model.Principal;
import com.ProjectGames.model.tictactoe.Tictactoe;
import com.ProjectGames.model.tictactoe.ValueSquare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementService {

    @Autowired
    private TictactoeService tictactoeService;

    public boolean putMoveInBoard(int idGame, int posX, int posY, String coin){
        System.out.println("Entro aqui");
        Tictactoe game = (Tictactoe) Principal.games.get(idGame);
        System.out.println("Aqui ya no entro");
        if(coin.equals("x")){
            game.getMyBoard().getBoard()[posX][posY].setMyValue(ValueSquare.X);
            return tictactoeService.verifyIsTicTacToe(game.getMyBoard(), posX, posY, ValueSquare.X);
        } else if(coin.equals("o")){
            game.getMyBoard().getBoard()[posX][posY].setMyValue(ValueSquare.O);
            return tictactoeService.verifyIsTicTacToe(game.getMyBoard(), posX, posY, ValueSquare.O);
        } 
        return false;
    }

}