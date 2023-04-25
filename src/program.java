import models.entities.chess.ChessMath;
import models.entities.chess.ChessPiece;
import models.entities.chess.ChessPostion;
import models.entities.chess.Exceptions.ChessExcetions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        ChessMath chessMath = new ChessMath();
        Scanner sc = new Scanner(System.in);
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMath.getCheckMate()){
            try {
                UI.clearScreen();
                UI.printMatch(chessMath, captured);


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

                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }
                if(chessMath.getPromoted() != null){
                    System.out.println("Enter piece for promotion (B/N/R/Q): ");
                    String type = sc.nextLine().toUpperCase();
                    while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")){
                        System.out.println("Ivalid, try again. Enter piece for promotion (B/N/R/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }
                    chessMath.replacePromotedPiece(type);
                }

            }catch (ChessExcetions | InputMismatchException e){
              System.out.println("Ops ->" + e.getMessage());
              sc.nextLine();
            }

        }
        UI.clearScreen();
        UI.printMatch(chessMath, captured);
    }
}
