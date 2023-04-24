package models.entities.chess.chessPieces;

import models.entities.boardGame.Board;
import models.entities.boardGame.Position;
import models.entities.chess.ChessPiece;
import models.entities.chess.enuns.EnumColor;

public class Queen extends ChessPiece {
    public Queen(Board board, EnumColor color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //Above
        p.setValues(position.getRow() -1, position.getColumn());
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //left
        p.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //rigth
        p.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //below
        p.setValues(position.getRow() +1, position.getColumn());
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
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