package no.uib.inf101.tetris.model.tetromino;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;

import org.junit.jupiter.api.Test;

public class TestTetromino {
    @Test
    public void testHashCodeAndEquals() {
        Tetromino t1 = Tetromino.newTetromino('T');
        Tetromino t2 = Tetromino.newTetromino('T');
        Tetromino t3 = Tetromino.newTetromino('T').shiftedBy(1, 0);
        Tetromino s1 = Tetromino.newTetromino('S');
        Tetromino s2 = Tetromino.newTetromino('S').shiftedBy(0, 0);

        assertEquals(t1, t2);
        assertEquals(s1, s2);
        assertEquals(t1.hashCode(), t2.hashCode());
        assertEquals(s1.hashCode(), s2.hashCode());
        assertNotEquals(t1, t3);
        assertNotEquals(t1, s1);
    }

    @Test
    public void tetrominoIterationOfT() {
        // Create a standard 'T' tetromino placed at (10, 100) to test
        Tetromino tetro = Tetromino.newTetromino('T');
        tetro = tetro.shiftedBy(10, 100);

        // Collect which objects are iterated through
        List<GridCell<Character>> objs = new ArrayList<>();
        for (GridCell<Character> gc : tetro) {
            objs.add(gc);
        }

        // Check that we got the expected GridCell objects
        assertEquals(4, objs.size());
        assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 100), 'T')));
        assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 101), 'T')));
        assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 102), 'T')));
        assertTrue(objs.contains(new GridCell<>(new CellPosition(12, 101), 'T')));

    }

    @Test
    public void tetrominoRotationOfT() {
        Tetromino tetro = Tetromino.newTetromino('T');
        tetro = tetro.shiftedBy(10, 10);

        // Collect which objects are iterated through
        List<GridCell<Character>> objs = new ArrayList<>();
        for (GridCell<Character> gc : tetro) {
            objs.add(gc);
        }

        // Check that we got the expected GridCell objects
        assertEquals(4, objs.size());
        assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 10), 'T')));
        assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 11), 'T')));
        assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 12), 'T')));
        assertTrue(objs.contains(new GridCell<>(new CellPosition(12, 11), 'T')));

        tetro = tetro.rotateTetromino();

        // Collect which objects are iterated through
        objs = new ArrayList<>();
        for (GridCell<Character> gc : tetro) {
            objs.add(gc);
        }
        assertTrue(objs.contains(new GridCell<>(new CellPosition(10, 11), 'T')));
        assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 11), 'T')));
        assertTrue(objs.contains(new GridCell<>(new CellPosition(12, 11), 'T')));
        assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 10), 'T')));
    }
}
