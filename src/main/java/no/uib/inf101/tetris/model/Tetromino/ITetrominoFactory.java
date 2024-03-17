package no.uib.inf101.tetris.model.tetromino;

/**
 * The ITetrominoFactory interface is for creating tetromino objects
 * It contains a method to get the next tetromino
 */
public interface ITetrominoFactory {
    /**
     *
     * @return the next tetromino
     */
    Tetromino getNext();
}
