package no.uib.inf101.tetris.controller;

import no.uib.inf101.tetris.model.GameState;

public interface IControllableTetrisModel {
    /**
     * 
     * @param deltaRow hvor mye den skal flyttes til siden
     * @param deltaCol hvor mye den skal flyttes opp og ned
     * @return en boolsk verdi som sier om flyttingen var vellykket
     */
    boolean moveTetromino(int deltaRow, int deltaCol);

    /**
     * 
     * @return en boolsk verdi som sier om rotasjonen var vellykket
     */
    boolean rotateTetromino();

    /** 
     * 
    */
    void dropTetromino();

    GameState gameState();

    int getTimerDelay();

    void clockTick();
}
