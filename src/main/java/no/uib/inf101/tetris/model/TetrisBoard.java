package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;

public class TetrisBoard extends Grid<Character> {

    /**
     * Represents a Tetris board.
     * The board is a grid of cells where Tetris pieces can be placed or removed
     * 
     * @param row the width
     * @param col the height
     */
    public TetrisBoard(int row, int col) {
        super(row, col);
        for (int i = 0; i < row; i++) {
            for (int n = 0; n < col; n++) {
                set(new CellPosition(i, n), '-');
            }
        }
    }

    /**
     * @return String formatet as a grid
     */
    public String prettyString() {
        String prettyString = "";
        for (int rows = 0; rows < rows(); rows++) {
            for (int cols = 0; cols < cols(); cols++) {
                prettyString += get(new CellPosition(rows, cols));
            }
            if (rows < rows() - 1) {
                prettyString += "\n";
            }
        }

        return prettyString;
    }

    public void clearBoard() {
        TetrisBoard board = this;
        for (int row = 0; row < rows(); row++) {
            for (int col = 0; col < cols(); col++){
                board.set(new CellPosition(row, col), '-');
            }
        }
    }

    private void setRowToDefaultChar() {
        TetrisBoard board = this;
        for (int col = 0; col < cols(); col++) {
            board.set(new CellPosition(0, col), '-');
        }
    }

    /**
     *
     * @return The number of rows removed from the Tetris board.
     */
    public int removeRow() {
        TetrisBoard board = this;
        int row = rows() - 1;
        int removedRowsCount = 0;
        while (row >= 0) {
            if (findFullRow(row)) {
                removedRowsCount++;
                board.removeFullRow(row);
                setRowToDefaultChar();
                row++;
            }
            row--;
        }
        return removedRowsCount;
    }

    /**
     * 
     * @param row the row to check
     * @return boolean that detirmins if a row is full
     */
    public boolean findFullRow(int row) {
        for (int col = 0; col < cols(); col++) {
            if (get(new CellPosition(row, col)) == '-') {
                return false;
            }
        }
        return true;
    }

}
