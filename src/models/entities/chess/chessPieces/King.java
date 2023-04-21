package models.entities.chess.chessPieces;

import models.entities.boardGame.Board;
import models.entities.boardGame.Position;
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

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //Above
        p.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //below
        p.setValues(position.getRow() + 1, position.getColumn());
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        // nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //se
        p.setValues(position.getRow() + 1, position.getColumn() +1);
        if(getBoard().positionsExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
