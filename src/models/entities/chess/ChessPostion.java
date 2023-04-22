package models.entities.chess;

import models.entities.boardGame.Position;
import models.entities.chess.Exceptions.ChessExcetions;

public class ChessPostion {
    private char column;
    private int row;

    public ChessPostion(char column, int row){
        if(column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessExcetions("Error instantiating chess position. valid  values are from a1 to h8");
        }
        this.column = column;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPostion fromPosition(Position position){
        return new ChessPostion((char)('a' + position.getColumn()), 8-position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
