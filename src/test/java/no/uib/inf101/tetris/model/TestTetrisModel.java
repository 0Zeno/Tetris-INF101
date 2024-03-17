package no.uib.inf101.tetris.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.tetris.controller.IControllableTetrisModel;
import no.uib.inf101.tetris.model.tetromino.ITetrominoFactory;
import no.uib.inf101.tetris.model.tetromino.PatternedTetrominoFactory;
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

  @Test
  public void initialPositionOfU() {
    TetrisBoard board = new TetrisBoard(20, 10);
    ITetrominoFactory factory = new PatternedTetrominoFactory("U");
    IViewableTetrisModel model = new TetrisModel(board, factory);

    List<GridCell<Character>> tetroCells = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCells.add(gc);
    }

    assertEquals(5, tetroCells.size());
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'U')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 3), 'U')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 5), 'U')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 4), 'U')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 3), 'U')));
  }

  @Test
  public void initialPositionOfT() {
    TetrisBoard board = new TetrisBoard(20, 10);
    ITetrominoFactory factory = new PatternedTetrominoFactory("T");
    IViewableTetrisModel model = new TetrisModel(board, factory);

    List<GridCell<Character>> tetroCells = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCells.add(gc);
    }

    assertEquals(4, tetroCells.size());
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 4), 'T')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 3), 'T')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'T')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 4), 'T')));
  }

  @Test
  public void testSucsessfullMoveTetromino() {
    TetrisBoard board = new TetrisBoard(20, 10);
    ITetrominoFactory tetromino = new PatternedTetrominoFactory("T");
    IControllableTetrisModel model = new TetrisModel(board, tetromino);

    assertTrue(model.moveTetromino(1, 1));
    assertFalse(model.moveTetromino(100, 100));
  }

  @Test
  public void testDropTetromino() {
    //TODO:
  }

  @Test
  public void testClockTick(){
    TetrisBoard board = new TetrisBoard(20, 10);
    ITetrominoFactory factory = new PatternedTetrominoFactory("O");
    TetrisModel model = new TetrisModel(board, factory);

    model.clockTick();
    model.clockTick();

    List<GridCell<Character>> tetroCells = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCells.add(gc);
    }

    assertEquals(4, tetroCells.size());
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(3, 4), 'O')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(3, 5), 'O')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(2, 4), 'O')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(2, 5), 'O')));
  }
}
