package no.uib.inf101.tetris.controller;

public interface IControllableTetrisModel {
    /**
     * 
     * @param deltaRow hvor mye den skal flyttes til siden
     * @param deltaCol hvor mye den skal flyttes opp og ned
     * @return en boolsk verdi som sier om flyttingen var vellykket
     */
    public boolean moveTetromino(int deltaRow, int deltaCol);


    /**
     * 
     * @return en boolsk verdi som sier om rotasjonen var vellykket
     */
    public boolean rotateTetromino();
}
