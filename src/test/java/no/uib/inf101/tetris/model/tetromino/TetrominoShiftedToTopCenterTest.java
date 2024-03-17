package no.uib.inf101.tetris.model.tetromino;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import no.uib.inf101.tetris.model.TetrisBoard;

public class TetrominoShiftedToTopCenterTest {
    @Test
    public void TestIShiftedToTopCenter() {
        TetrisBoard board = new TetrisBoard(10, 20);
        Tetromino tetro = Tetromino.newTetromino('I');
        Tetromino testTetro = tetro.shiftedToTopCenterOf(board);

        assertEquals(testTetro, tetro.shiftedBy(-1, 8));
    }
    @Test
    public void TestOShiftedToTopCenter() {
        TetrisBoard board = new TetrisBoard(10, 20);
        Tetromino tetro = Tetromino.newTetromino('O');
        Tetromino testTetro = tetro.shiftedToTopCenterOf(board);

        assertEquals(testTetro, tetro.shiftedBy(-1, 8));
    }

    @Test
    public void TestTShiftedToTopCenter() {
        TetrisBoard board = new TetrisBoard(10, 20);
        Tetromino tetro = Tetromino.newTetromino('T');
        Tetromino testTetro = tetro.shiftedToTopCenterOf(board);

        assertEquals(testTetro, tetro.shiftedBy(-1, 8));
    }
}
