package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.Grid;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.view.IViewbleTetrisModel;

public class TetrisModel implements IViewbleTetrisModel {
    TetrisBoard board;

    public TetrisModel(TetrisBoard board){
        this.board = board;
    }

    @Override
    public GridDimension getDimentions() {
        return new Grid<>(board.rows(), board.cols());
    }

    @Override
    public Iterable<GridCell<Character>> getTilesOnBoard() {
       return board;
    }
    
}
