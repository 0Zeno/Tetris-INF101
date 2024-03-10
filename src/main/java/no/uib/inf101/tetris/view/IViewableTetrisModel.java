package no.uib.inf101.tetris.view;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;

public interface IViewableTetrisModel {

    public GridDimension getDimentions();

    public Iterable<GridCell<Character>> getTilesOnBoard();

    public Iterable<GridCell<Character>> fallingTetromino();

}
