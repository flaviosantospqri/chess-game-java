package models.entities.chess;

import models.entities.boardGame.Board;
import models.entities.boardGame.Piece;
import models.entities.boardGame.Position;
import models.entities.chess.Exceptions.ChessExcetions;
import models.entities.chess.chessPieces.King;
import models.entities.chess.chessPieces.Rook;
import models.entities.chess.enuns.EnumColor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChessMath {
    private int turn;
    private EnumColor currentPlayer;
    private Board board;
    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();
    private boolean check;

    public ChessMath() {
        board = new Board(8, 8);
        turn = 1;
        check = false;
        currentPlayer = EnumColor.WHITE;
        initialSetup();
    }

    public int getTurn(){
        return turn;
    }

    public boolean getCheck(){
        return check;
    }

    public EnumColor getCurrentPlayer() {
        return currentPlayer;
    }

    public EnumColor opponent(EnumColor color){
        return (color == EnumColor.WHITE) ? EnumColor.BLACK : EnumColor.WHITE;
    }

    private ChessPiece king(EnumColor color){
        List<Piece> list = piecesOnTheBoard.stream().filter(x ->((ChessPiece)x).getColor() == color).collect(Collectors.toList());

        for(Piece p: list){
            if(p instanceof King){
                return (ChessPiece)p;
            }
        }
        throw new IllegalArgumentException("There is no " + color + "king in the board");
    }

    private boolean testCheck(EnumColor color){
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> oponnentPieces = piecesOnTheBoard.stream().filter(x ->((ChessPiece)x).getColor() == opponent(color)).collect(Collectors.toList());
        for(Piece p: oponnentPieces){
            boolean[][] mat = p.possibleMoves();
            if(mat[kingPosition.getRow()][kingPosition.getColumn()]){
                return true;
            }
        }
        return false;
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

    public boolean[][] possibleMoves(ChessPostion sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);

        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPostion sourcePosition, ChessPostion targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);

        if(testCheck(currentPlayer)){
            undoMove(source, target, capturedPiece);
            throw new ChessExcetions("You can't put yourself in check");
        }

        check = testCheck(opponent(currentPlayer));

        nextTurn();
        return (ChessPiece)capturedPiece;
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        if(capturedPiece != null){
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        board.placePiece(p,target);

        return capturedPiece;
    }

    private void undoMove(Position source, Position target, Piece capturedPiece){
        Piece p = board.removePiece(target);
        board.placePiece(p,source);

        if(capturedPiece != null){
            board.placePiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
            piecesOnTheBoard.add(capturedPiece);
        }
    }

    private void validateSourcePosition(Position position) {
        if(!board.thereIsAPiece(position)){
            throw new ChessExcetions("There is no piece on source position");
        }
        if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()){
            throw new ChessExcetions("The chosen piece is not yours");
        }
        if(!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessExcetions("Not exists possible move for chosen piece ");
        }
    }

    private void validateTargetPosition(Position source, Position target) {
        if(!board.piece(source).possibleMove(target)){
            throw new ChessExcetions("The chosen piece cant's moves to target position");
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPostion(column, row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == EnumColor.WHITE) ? EnumColor.BLACK : EnumColor.WHITE;
    }

    private void initialSetup(){
        placeNewPiece('c', 1, new Rook(board, EnumColor.WHITE));
        placeNewPiece('c', 2, new Rook(board, EnumColor.WHITE));
        placeNewPiece('d', 2, new Rook(board, EnumColor.WHITE));
        placeNewPiece('e', 2, new Rook(board, EnumColor.WHITE));
        placeNewPiece('e', 1, new Rook(board, EnumColor.WHITE));
        placeNewPiece('d', 1, new King(board, EnumColor.WHITE));

        placeNewPiece('c', 7, new Rook(board, EnumColor.BLACK));
        placeNewPiece('c', 8, new Rook(board, EnumColor.BLACK));
        placeNewPiece('d', 7, new Rook(board, EnumColor.BLACK));
        placeNewPiece('e', 7, new Rook(board, EnumColor.BLACK));
        placeNewPiece('e', 8, new Rook(board, EnumColor.BLACK));
        placeNewPiece('d', 8, new King(board, EnumColor.BLACK));
    }
}
