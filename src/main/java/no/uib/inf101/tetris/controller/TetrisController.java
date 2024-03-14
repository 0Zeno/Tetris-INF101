package no.uib.inf101.tetris.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import no.uib.inf101.tetris.model.GameState;
import no.uib.inf101.tetris.view.TetrisView;

public class TetrisController implements java.awt.event.KeyListener {
    private IControllableTetrisModel controllableTetrisModel;
    private TetrisView tetrisView;
    private Timer timer;

    public TetrisController(IControllableTetrisModel controllableTetrisModel, TetrisView tetrisView) {
        this.tetrisView = tetrisView;
        this.controllableTetrisModel = controllableTetrisModel;
        this.tetrisView.setFocusable(true);
        this.tetrisView.addKeyListener(this);
        this.timer = new Timer(controllableTetrisModel.getTimerDelay(), this::clockTick);
        timer.start();
    }

    /**
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * @param e the pressed key
     */
    @Override
    public void keyPressed(KeyEvent e) {

        if (controllableTetrisModel.gameState() == GameState.ACTIVE_GAME) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                controllableTetrisModel.moveTetromino(0, -1);
                System.out.println("move to the left");
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                controllableTetrisModel.moveTetromino(0, 1);
                System.out.println("move to the right");
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                controllableTetrisModel.moveTetromino(1, 0);
                System.out.println("move to the down");
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                controllableTetrisModel.rotateTetromino();

            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                controllableTetrisModel.dropTetromino();
            }
            tetrisView.repaint();
        }
    }

    
    /** 
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void clockTick(ActionEvent actionEvent) {
        if (controllableTetrisModel.gameState() == GameState.ACTIVE_GAME) {
            controllableTetrisModel.clockTick();
            delay();
            tetrisView.repaint();
        }
    }

    private void delay() {
        int delay = controllableTetrisModel.getTimerDelay();
        timer.setDelay(delay);
        timer.setInitialDelay(delay);
    }

}
