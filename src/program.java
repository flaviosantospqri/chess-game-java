import models.entities.boardGame.Board;
import models.entities.chess.ChessMath;
import models.entities.chess.ChessPiece;
import models.entities.chess.ChessPostion;
import models.entities.chess.Exceptions.ChessExcetions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        ChessMath chessMath = new ChessMath();
        Scanner sc = new Scanner(System.in);

        while (true){
            try {
                UI.clearScreen();
                UI.printBoard(chessMath.getPieces());

                System.out.println();
                System.out.print("Source: ");
                ChessPostion source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMath.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMath.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPostion target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMath.performChessMove(source, target);
            }catch (ChessExcetions | InputMismatchException e){
                System.out.println("Ops ->" + e.getMessage());
                sc.nextLine();
            }

        }
    }
}
