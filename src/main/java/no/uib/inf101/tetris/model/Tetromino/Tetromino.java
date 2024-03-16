package no.uib.inf101.tetris.model.Tetromino;

import java.util.Iterator;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;

public class Tetromino implements Iterable<GridCell<Character>> {
    private char tetrominoType;
    private boolean[][] tetrominoShape;
    private CellPosition cellPos;

    /**
     * 
     * @param tetrominoType  a character that represents a tetromino type
     * @param tetrominoShape a 2d list with boolead values that represents the
     *                       tetromip shape
     * @param cellPos        the position of the tetromino
     */
    private Tetromino(char tetrominoType, boolean[][] tetrominoShape, CellPosition cellPos) {
        this.tetrominoType = tetrominoType;
        this.tetrominoShape = tetrominoShape;
        this.cellPos = cellPos;
    }

    /**
     * 
     * @param tetrominoType a character that represents a tetromino type
     * @return Tetromino shape, type and pos in (0, 0)
     */
    protected static Tetromino newTetromino(char tetrominoType) {
        boolean[][] tetrominoShape;
        switch (tetrominoType) {
            case 'U':
                tetrominoShape = new boolean[][] {
                        { false, false, false },
                        { true, false, true },
                        { true, true, true } };
                break;
            case 'L':
                tetrominoShape = new boolean[][] {
                        { false, false, false },
                        { true, true, true },
                        { true, false, false } };
                break;
            case 'J':
                tetrominoShape = new boolean[][] {
                        { false, false, false },
                        { true, true, true },
                        { false, false, true } };
                break;
            case 'S':
                tetrominoShape = new boolean[][] {
                        { false, false, false },
                        { false, true, true },
                        { true, true, false } };
                break;
            case 'Z':
                tetrominoShape = new boolean[][] {
                        { false, false, false },
                        { true, true, false },
                        { false, true, true } };
                break;
            case 'T':
                tetrominoShape = new boolean[][] {
                        { false, false, false },
                        { true, true, true },
                        { false, true, false } };
                break;
            case 'I':
                tetrominoShape = new boolean[][] {
                        { false, false, false, false },
                        { true, true, true, true },
                        { false, false, false, false },
                        { false, false, false, false } };
                break;
            case 'O':
                tetrominoShape = new boolean[][] {
                        { false, false, false, false },
                        { false, true, true, false },
                        { false, true, true, false },
                        { false, false, false, false } };
                break;
            default:
                throw new IllegalArgumentException("No such tetromino type: " + tetrominoType);
        }
        return new Tetromino(tetrominoType, tetrominoShape, new CellPosition(0, 0));
    }

    /**
     * @param deltaRow how many rows the tetromino is shifted by
     * @param deltaCol how many cols the tetromino is shifted by
     * @return Shifted tetromino position
     */
    public Tetromino shiftedBy(int deltaRow, int deltaCol) {
        CellPosition pos = new CellPosition(cellPos.row() + deltaRow, cellPos.col() + deltaCol);
        return (new Tetromino(tetrominoType, tetrominoShape, pos));
    }

    /**
     * 
     * @param gridDimension the dinentions of the grid
     * @return tetromino on center and top of grid
     */
    public Tetromino shiftedToTopCenterOf(GridDimension gridDimension) {
        int col = 0;
        if (gridDimension.cols() % 2 == 0) {
            col = gridDimension.cols() / 2 - 1;
        } else {
            col = gridDimension.cols() / 2 - 2;
        }
        return (new Tetromino(tetrominoType, tetrominoShape, new CellPosition(-1, col - 1)));
    }

    /**
     * @return a Iterator<GridCell<Character>>
     */
    public Iterator<GridCell<Character>> iterator() {
        ArrayList<GridCell<Character>> list = new ArrayList<GridCell<Character>>();
        for (int i = 0; i < tetrominoShape.length; i++) {
            for (int n = 0; n < tetrominoShape.length; n++) {
                if (tetrominoShape[i][n]) {
                    list.add(new GridCell<Character>(new CellPosition(cellPos.row() + i, cellPos.col() + n),
                            this.tetrominoType));
                }
            }
        }
        return list.iterator();

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Tetromino otherTetromino = ((Tetromino) obj);
        return tetrominoType == otherTetromino.tetrominoType && cellPos.equals(otherTetromino.cellPos)
                && Arrays.deepEquals(tetrominoShape, otherTetromino.tetrominoShape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tetrominoType, Arrays.deepHashCode(this.tetrominoShape), this.cellPos);
    }

    /**
     * 
     * @return a rotated tetromino object
     */
    public Tetromino rotateTetromino() {
        System.out.println("Calling the rotate method");
        int cols = tetrominoShape[0].length;
        int rows = tetrominoShape.length;

        boolean[][] rotatedShape = new boolean[cols][rows];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rotatedShape[col][rows - 1 - row] = tetrominoShape[row][col];
            }
        }
        return new Tetromino(tetrominoType, rotatedShape, cellPos);
    }

}