package no.uib.inf101.tetris.view;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.model.GameState;

/**
 * This interface represents a viewable Tetris model.
 * It provides methods to retrieve information about the Tetris gamestate and its coponents.
 */
public interface IViewableTetrisModel {

    /**
     *
     * @return the dimensions of the Tetris grid
     */
    GridDimension getDimensions();

    /**
     *
     * @return an iterable of the tiles currently on the Tetris board
     */
    Iterable<GridCell<Character>> getTilesOnBoard();

    /**
     *
     * @return an iterable of the tiles in the falling Tetromino
     */
    Iterable<GridCell<Character>> fallingTetromino();

    /**
     *
     * @return the current game state of the Tetris game
     */
    GameState gameState();

}
