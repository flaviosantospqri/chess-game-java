package models.entities.chess.chessPieces;

import models.entities.boardGame.Board;
import models.entities.boardGame.Position;
import models.entities.chess.ChessMath;
import models.entities.chess.ChessPiece;
import models.entities.chess.enuns.EnumColor;

public class Pawn extends ChessPiece {
    private ChessMath chessMath;

    public Pawn(Board board, EnumColor color, ChessMath chessMath) {
        super(board, color);
        this.chessMath = chessMath;
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        if(getColor() == EnumColor.WHITE){
            p.setValues(position.getRow() - 1, position.getColumn());
            if(getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if(getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionsExists(p2) && !getBoard().thereIsAPiece(p2) && getBoard().positionsExists(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            if(position.getRow() == 3){
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionsExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMath.getEnPassantVulnerable()){
                    mat[left.getRow() - 1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionsExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMath.getEnPassantVulnerable()){
                    mat[right.getRow() - 1][right.getColumn()] = true;
                }
            }
        }else {
            p.setValues(position.getRow() + 1, position.getColumn());
            if(getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if(getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionsExists(p2) && !getBoard().thereIsAPiece(p2) && getBoard().positionsExists(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if(getBoard().positionsExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            if(position.getRow() == 4){
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionsExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMath.getEnPassantVulnerable()){
                    mat[left.getRow() + 1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionsExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMath.getEnPassantVulnerable()){
                    mat[right.getRow() + 1][right.getColumn()] = true;
                }
            }

        }

        return mat;
    }


}
