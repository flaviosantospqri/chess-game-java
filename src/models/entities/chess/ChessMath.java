package models.entities.chess;

import models.entities.boardGame.Board;
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
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPostion(column, row).toPosition());
    }

    private void initialSetup(){
        placeNewPiece('b', 6, new Rook(board, EnumColor.WHITE));
        placeNewPiece('e', 8, new King(board, EnumColor.BLACK));
        placeNewPiece('e', 1, new King(board, EnumColor.WHITE));
    }
}
