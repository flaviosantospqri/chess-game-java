package models.entities.chess;

import models.entities.boardGame.Board;
import models.entities.boardGame.Piece;
import models.entities.boardGame.Position;
import models.entities.chess.enuns.EnumColor;


public abstract class ChessPiece extends Piece {
    private EnumColor color;
    private int moveCount;

    public ChessPiece(Board board, EnumColor color) {
        super(board);
        this.color = color;
    }

    public EnumColor getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void increaseMoveCount(){
        moveCount++;
    }

    public void decreaseMoveCount(){
        moveCount--;
    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);

        return p != null && p.getColor() != color;
    }

    public ChessPostion getChessPosition(){
        return ChessPostion.fromPosition(position);
    }
}
