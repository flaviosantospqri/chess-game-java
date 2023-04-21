package models.entities.chess.chessPieces;

import models.entities.boardGame.Board;
import models.entities.boardGame.Position;
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

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //Above
        p.setValues(position.getRow() -1, position.getColumn());
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][position.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][position.getColumn()] = true;
        }

        //left
        p.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][position.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][position.getColumn()] = true;
        }

        //rigth
        p.setValues(position.getRow() -1, position.getColumn() + 1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][position.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][position.getColumn()] = true;
        }
        //below
        p.setValues(position.getRow() +1, position.getColumn());
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][position.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][position.getColumn()] = true;
        }

        return mat;
    }
}

