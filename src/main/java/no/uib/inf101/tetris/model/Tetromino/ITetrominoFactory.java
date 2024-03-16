package no.uib.inf101.tetris.model.Tetromino;

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
