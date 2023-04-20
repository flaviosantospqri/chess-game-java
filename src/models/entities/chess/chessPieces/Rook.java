package models.entities.chess.chessPieces;

import models.entities.boardGame.Board;
import models.entities.chess.ChessPiece;
import models.entities.chess.enuns.EnumColor;

public class Rook extends ChessPiece {
    public Rook(Board board, EnumColor color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }
}
