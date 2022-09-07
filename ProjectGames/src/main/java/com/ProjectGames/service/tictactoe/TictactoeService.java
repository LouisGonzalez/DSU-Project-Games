package com.ProjectGames.service.tictactoe;

import com.ProjectGames.DTO.GameDataDTO;
import com.ProjectGames.DTO.PlayerDTO;
import com.ProjectGames.model.Player;
import com.ProjectGames.model.Principal;
import com.ProjectGames.model.TypeGame;
import com.ProjectGames.model.tictactoe.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TictactoeService {

    public List<GameDataDTO> findAllGames(){
        List<GameDataDTO> listGames = new ArrayList<>();
        for (int i = 0; i < Principal.games.size(); i++) {
            if(Principal.games.get(i).getTypeGame() == TypeGame.TICTACTOE) {
                Tictactoe game = (Tictactoe) Principal.games.get(i);
                Player playerX = game.getPlayerX();
                Player playerO = game.getPlayerO();
                PlayerDTO playerXsend = new PlayerDTO(game.getIdPlayers().get(0), playerX.getName(), playerX.getTypePlayer(), playerX.getAge());
                PlayerDTO playerOsend = new PlayerDTO(game.getIdPlayers().get(1), playerO.getName(), playerO.getTypePlayer(), playerX.getAge());
                GameDataDTO gameDTO = new GameDataDTO(i, game.getCountMoves(), playerXsend, playerOsend);
                listGames.add(gameDTO);
            }
        }
        return listGames;
    }

    public GameDataDTO findDataGame(Long idGame){
        Tictactoe game = (Tictactoe) Principal.games.get(idGame.intValue());
        Player playerX = game.getPlayerX();
        Player playerO = game.getPlayerO();
        PlayerDTO playerXsend = new PlayerDTO(game.getIdPlayers().get(0), playerX.getName(), playerX.getTypePlayer(), playerX.getAge());
        PlayerDTO playerOsend = new PlayerDTO(game.getIdPlayers().get(1), playerO.getName(), playerO.getTypePlayer(), playerX.getAge());
        GameDataDTO gameSend = new GameDataDTO(game.getCountMoves(), playerXsend, playerOsend);
        return gameSend;
    }

    public List<MovementGame> findAllSquares(Long idGame){
        List<MovementGame> list = new ArrayList<>();
        Tictactoe game = (Tictactoe) Principal.games.get(idGame.intValue());
        for (int i = 0; i < game.getMyBoard().BOARD_SIZE; i++) {
            for (int j = 0; j < game.getMyBoard().BOARD_SIZE; j++) {
                Square square = game.getMyBoard().getBoard()[i][j];
                MovementGame move = new MovementGame(idGame.intValue(), i, j, square.getMyValue().toString());
                list.add(move);
            }
        }
        return list;
    }

    public boolean isEmptySpaces(int countMoves){
        if(countMoves >= 9) return true;
        return false;
    }

    public boolean verifyIsTicTacToe(Board board, int posX, int posY, ValueSquare value){
        return verifyWinX(board, posX, posY, value);
    }

    public boolean verifyWinX(Board board, int posX, int posY, ValueSquare value){
        int auxX = 0;
        while(auxX < board.BOARD_SIZE){
            if(auxX != posX){
                if(board.getBoard()[auxX][posY].getMyValue() != value)
                    return verifyWinY(board, posX, posY, value);
            }
            auxX++;
        }
        return true;
    }

    public boolean verifyWinY(Board board, int posX, int posY, ValueSquare value){
        int auxY = 0;
        while(auxY < board.BOARD_SIZE){
            if(auxY != posY){
                if(board.getBoard()[posX][auxY].getMyValue() != value)
                    return verifyWinXY(board, value);
            }
            auxY++;
        }
        return true;

    }

    public boolean verifyWinXY(Board board, ValueSquare value){
        int auxX = 0, auxY = 0;
        while(auxX < board.BOARD_SIZE && auxY < board.BOARD_SIZE){
            if(board.getBoard()[auxX][auxY].getMyValue() != value)
                return verifyWinYX(board, value);
            auxX++; auxY++;
        }
        return true;
    }

    public boolean verifyWinYX(Board board, ValueSquare value){
        int auxX = 0, auxY = 2;
        while(auxX < board.BOARD_SIZE && auxY < board.BOARD_SIZE){
            if(board.getBoard()[auxX][auxY].getMyValue() != value)
                return false;
            auxX++; auxY--;
        }
        return true;
    }

}
