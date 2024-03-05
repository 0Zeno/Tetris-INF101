package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;

public class TetrisBoard extends Grid<Character>{

    public TetrisBoard(int row, int col) {
        super(row, col);
        for (int i = 0; i < row; i++) {
            for (int n = 0; n < col; n++){
                set(new CellPosition(i, n), '-');
            }
        }
    }

    public String prettyString() {
        String prettyString = "";
        for (int rows = 0; rows < rows(); rows++){
            for (int cols = 0; cols < cols(); cols++){
                prettyString += get(new CellPosition(rows, cols));
            }
            if (rows < rows() - 1){
                prettyString += "\n";
            }
        }

        return prettyString;
    }
    
}
