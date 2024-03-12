package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.controller.IControllableTetrisModel;
import no.uib.inf101.tetris.model.Tetromino.ITetrominoFactory;
import no.uib.inf101.tetris.model.Tetromino.Tetromino;
import no.uib.inf101.tetris.view.IViewableTetrisModel;

public class TetrisModel implements IViewableTetrisModel, IControllableTetrisModel {
    TetrisBoard board;
    ITetrominoFactory factory;
    Tetromino tetromino;

    public TetrisModel(TetrisBoard board, ITetrominoFactory factory) {
        this.board = board;
        this.factory = factory;
        tetromino = this.factory.getNext().shiftedToTopCenterOf(board);
    }

    
    /** 
     * @return GridDimension
     */
    @Override
    public GridDimension getDimentions() {
        return board;
    }

    
    /** 
     * @return Iterable<GridCell<Character>>
     */
    @Override
    public Iterable<GridCell<Character>> getTilesOnBoard() {
        return board;
    }

    @Override
    public Iterable<GridCell<Character>> fallingTetromino() {
        return tetromino;
    }

    @Override
    public boolean moveTetromino(int deltaRow, int deltaCol) {
        Tetromino fallingTetromino = tetromino.shiftedBy(deltaRow, deltaCol);
        if (isLegalePlaceOnBoard(fallingTetromino)) {
            tetromino = fallingTetromino;
            return true;
        }
        return false;
    }

    private boolean isLegalePlaceOnBoard(Tetromino tetromino) {
        for (GridCell<Character> gridCellTetromino : tetromino) {
            if (!board.positionIsOnGrid(gridCellTetromino.pos())) {
                return false;
            } else if (board.get(gridCellTetromino.pos()) != '-') {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean rotateTetromino() {
        Tetromino testTetromino = tetromino.rotateTetromino();
        if (isLegalePlaceOnBoard(testTetromino)) {
            tetromino = testTetromino;
            return true;

        }
        return false;
    }

}
