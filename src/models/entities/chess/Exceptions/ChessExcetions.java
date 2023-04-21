package models.entities.chess.Exceptions;

import models.entities.boardGame.Excpetions.BoardException;

public class ChessExcetions extends BoardException {
    private static final long serialVersionUID = 1L;

    public ChessExcetions(String msg){
        super(msg);
    }
}
