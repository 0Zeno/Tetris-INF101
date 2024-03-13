package no.uib.inf101.tetris.view;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.model.GameState;

public interface IViewableTetrisModel {

    GridDimension getDimentions();

    Iterable<GridCell<Character>> getTilesOnBoard();

    Iterable<GridCell<Character>> fallingTetromino();

    GameState gameState();

}
