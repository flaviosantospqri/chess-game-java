package models.entities.chess.chessPieces;

import models.entities.boardGame.Board;
import models.entities.chess.ChessPiece;
import models.entities.chess.enuns.EnumColor;

public class King extends ChessPiece {
    public King(Board board, EnumColor color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        return new boolean[getBoard().getRows()][getBoard().getColumns()];
    }
}
