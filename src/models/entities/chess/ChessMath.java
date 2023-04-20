package models.entities.chess;

import models.entities.boardGame.Board;
import models.entities.boardGame.Position;
import models.entities.chess.chessPieces.King;
import models.entities.chess.chessPieces.Rook;
import models.entities.chess.enuns.EnumColor;

public class ChessMath {
    private Board board;

    public ChessMath() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void initialSetup(){
        board.placePiece(new Rook(board, EnumColor.WHITE), new Position(2,1));
        board.placePiece(new King(board, EnumColor.BLACK), new Position(0,4));
        board.placePiece(new King(board, EnumColor.WHITE), new Position(7,4));
    }
}
