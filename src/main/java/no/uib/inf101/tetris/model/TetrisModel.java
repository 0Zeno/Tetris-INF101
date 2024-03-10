package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.Grid;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.model.Tetromino.ITetrominoFactory;
import no.uib.inf101.tetris.model.Tetromino.Tetromino;
import no.uib.inf101.tetris.view.IViewableTetrisModel;

public class TetrisModel implements IViewableTetrisModel {
    TetrisBoard board;
    ITetrominoFactory factory;
    Tetromino tetromino;

    public TetrisModel(TetrisBoard board, ITetrominoFactory factory) {
        this.board = board;
        this.factory = factory;
        tetromino = this.factory.getNext().shiftedToTopCenterOf(board);
    }

    @Override
    public GridDimension getDimentions() {
        return new Grid<>(board.rows(), board.cols());
    }

    @Override
    public Iterable<GridCell<Character>> getTilesOnBoard() {
        return board;
    }

    @Override
    public Iterable<GridCell<Character>> fallingTetromino() {
        return tetromino;
    }

}
