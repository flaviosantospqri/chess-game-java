package models.entities.chess.chessPieces;

import models.entities.boardGame.Board;
import models.entities.boardGame.Position;
import models.entities.chess.ChessPiece;
import models.entities.chess.enuns.EnumColor;

public class Bishop extends ChessPiece {


    public Bishop(Board board, EnumColor color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //nw
        p.setValues(position.getRow() -1, position.getColumn() - 1) ;
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //ne
        p.setValues(position.getRow() - 1 , position.getColumn() + 1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //sw
        p.setValues(position.getRow() + 1, position.getColumn() -1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }


}
