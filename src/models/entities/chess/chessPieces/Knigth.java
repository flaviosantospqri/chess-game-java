package models.entities.chess.chessPieces;

import models.entities.boardGame.Board;
import models.entities.boardGame.Position;
import models.entities.chess.ChessPiece;
import models.entities.chess.enuns.EnumColor;

public class Knigth extends ChessPiece {
    public Knigth(Board board, EnumColor color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);


        p.setValues(position.getRow() - 1, position.getColumn() - 2);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() -2, position.getColumn() +1);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() -1, position.getColumn() + 2);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() + 1, position.getColumn() + 2);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() + 2, position.getColumn() + 1);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() + 2, position.getColumn() - 1);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() + 1, position.getColumn() - 2);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() -2, position.getColumn() -1);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
