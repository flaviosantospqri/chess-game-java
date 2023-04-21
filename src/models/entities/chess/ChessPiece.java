package models.entities.chess;

import models.entities.boardGame.Board;
import models.entities.boardGame.Piece;
import models.entities.chess.enuns.EnumColor;


public abstract class ChessPiece extends Piece {
    private EnumColor color;

    public ChessPiece(Board board, EnumColor color) {
        super(board);
        this.color = color;
    }

    public EnumColor getColor() {
        return color;
    }

}
