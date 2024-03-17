package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.controller.IControllableTetrisModel;
import no.uib.inf101.tetris.model.tetromino.ITetrominoFactory;
import no.uib.inf101.tetris.model.tetromino.Tetromino;
import no.uib.inf101.tetris.view.IViewableTetrisModel;

public class TetrisModel implements IViewableTetrisModel, IControllableTetrisModel {
    private TetrisBoard board;
    private ITetrominoFactory factory;
    private Tetromino tetromino;
    private GameState currentGameState;

    public TetrisModel(TetrisBoard board, ITetrominoFactory factory) {
        this.board = board;
        this.factory = factory;
        tetromino = this.factory.getNext().shiftedToTopCenterOf(board);
        currentGameState = GameState.ACTIVE_GAME;
    }

    @Override
    public Iterable<GridCell<Character>> getTilesOnBoard() {
        return board;
    }

    @Override
    public Iterable<GridCell<Character>> fallingTetromino() {
        return tetromino;
    }

    @Override
    public boolean moveTetromino(int deltaRow, int deltaCol) {
        Tetromino fallingTetromino = tetromino.shiftedBy(deltaRow, deltaCol);
        if (isLegalePlaceOnBoard(fallingTetromino)) {
            tetromino = fallingTetromino;
            return true;
        }
        return false;
    }

    /**
     * Checks if a given tetromino can be placed legally on the board.
     *
     * @param tetromino the tetromino to be checked
     * @return true if the tetromino can be placed legally on the board, false
     *         otherwise
     */
    private boolean isLegalePlaceOnBoard(Tetromino tetromino) {
        for (GridCell<Character> gridCellTetromino : tetromino) {
            if (!board.positionIsOnGrid(gridCellTetromino.pos())) {
                return false;
            } else if (board.get(gridCellTetromino.pos()) != '-') {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean rotateTetromino() {
        Tetromino testTetromino = tetromino.rotateTetromino();
        if (isLegalePlaceOnBoard(testTetromino)) {
            tetromino = testTetromino;
            return true;

        }
        return false;
    }

    /**
     * Gets new falling tetromino and checks if the position is leagle
     * Changes the gamestate if the new tetromino is placed ileagaly
     */
    public void getNewFallingTetromino() {
        Tetromino newFallingTetromino = factory.getNext().shiftedToTopCenterOf(board);
        if (isLegalePlaceOnBoard(newFallingTetromino) && gameState() == GameState.ACTIVE_GAME) {
            tetromino = newFallingTetromino;
        } else {
            currentGameState = GameState.GAME_OVER;
        }

    }

    /**
     * glues tetromino to the board
     */
    private void glueTetromino() {
        for (GridCell<Character> cell : tetromino) {
            CellPosition pos = cell.pos();
            board.set(pos, cell.value());
        }
    }

    @Override
    public void dropTetromino() {
        while (moveTetromino(1, 0));
            glueTetromino();
            board.removeRow();
            getNewFallingTetromino();

    }

    @Override
    public GameState gameState() {
        return currentGameState;
    }

    @Override
    public int getTimerDelay() {
        return 500;
    }

    @Override
    public void clockTick() {
        if (moveTetromino(1, 0)) {
        } else {
            glueTetromino();
            getNewFallingTetromino();
        }

    }

    @Override
    public GridDimension getDimensions() {
        return board;
    }

}
