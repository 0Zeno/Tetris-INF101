package no.uib.inf101.tetris.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test; // Add this import statement

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.tetris.model.Tetromino.ITetrominoFactory;
import no.uib.inf101.tetris.model.Tetromino.PatternedTetrominoFactory;
import no.uib.inf101.tetris.view.IViewableTetrisModel;

public class TestTetrisModel {

  @Test
  public void initialPositionOfO() {
    TetrisBoard board = new TetrisBoard(20, 10);
    ITetrominoFactory factory = new PatternedTetrominoFactory("O");
    IViewableTetrisModel model = new TetrisModel(board, factory);

    List<GridCell<Character>> tetroCells = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCells.add(gc);
    }

    assertEquals(4, tetroCells.size());
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 4), 'O')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'O')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 4), 'O')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 5), 'O')));
  }

  @Test
  public void initialPositionOfI() {
    TetrisBoard board = new TetrisBoard(20, 10);
    ITetrominoFactory factory = new PatternedTetrominoFactory("I");
    IViewableTetrisModel model = new TetrisModel(board, factory);

    List<GridCell<Character>> tetroCells = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCells.add(gc);
    }

    assertEquals(4, tetroCells.size());
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 3), 'I')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 4), 'I')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'I')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 6), 'I')));

  }

}
