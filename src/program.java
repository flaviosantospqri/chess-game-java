import models.entities.boardGame.Board;
import models.entities.chess.ChessMath;

public class program {
    public static void main(String[] args) {
        ChessMath chessMath = new ChessMath();

        UI.printBoard(chessMath.getPieces());

    }
}
