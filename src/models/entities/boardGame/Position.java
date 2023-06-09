package models.entities.boardGame;

public class Position {
    private int row;
    private int column;

    public Position(int line, int column) {
        this.row = line;
        this.column = column;
    }

    public Position() {
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return row + ", " + column;
    }

    public void setValues(int row, int column){
        this.row = row;
        this.column = column;
    }
}
