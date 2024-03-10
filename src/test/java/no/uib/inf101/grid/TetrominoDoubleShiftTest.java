package no.uib.inf101.grid;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import no.uib.inf101.tetris.model.Tetromino.Tetromino;

public class TetrominoDoubleShiftTest {
        @Test
        public void testTetrominoDoubleShift() {
            // Create a standard 'S' tetromino placed at (20, 10)
            // then moved twice to (25, 15) then (30, 20)
            Tetromino tetro2 = Tetromino.newTetromino('S').shiftedBy(20, 10);
            tetro2 = tetro2.shiftedBy(10, 10);
            Tetromino tetro3 = Tetromino.newTetromino('S').shiftedBy(30, 20);
    
            assertEquals(tetro2, tetro3);
    }

}
