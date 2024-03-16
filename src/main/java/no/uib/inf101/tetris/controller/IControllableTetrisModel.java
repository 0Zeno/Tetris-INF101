package no.uib.inf101.tetris.controller;

import no.uib.inf101.tetris.model.GameState;

public interface IControllableTetrisModel {
    /**
     * 
     * @param deltaRow how many rows to move the tetromino
     * @param deltaCol how many cols to move the tetromino
     * @return true if the movement was leagle, false otherwise
     */
    boolean moveTetromino(int deltaRow, int deltaCol);

    /**
     * Rotates the tetromino.
     * 
     * @return true if the rotation was leagle, false otherwise
     */
    boolean rotateTetromino();

    /**
     * Drops the tetromino to the bottom of the grid.
     */
    void dropTetromino();

    /**
     * 
     * @return the current game state
     */
    GameState gameState();

    /**
     * 
     * @return the delay for the timer
     */
    int getTimerDelay();

    /**
     * Advances the game by one clock tick.
     */
    void clockTick();
}
