package no.uib.inf101.tetris.controller;

import java.awt.event.KeyEvent;

import no.uib.inf101.tetris.model.GameState;
import no.uib.inf101.tetris.view.TetrisView;

public class TetrisController implements java.awt.event.KeyListener {
    private IControllableTetrisModel controllableTetrisModel;
    private TetrisView tetrisView;

    public TetrisController(IControllableTetrisModel controllableTetrisModel, TetrisView tetrisView) {
        this.tetrisView = tetrisView;
        this.controllableTetrisModel = controllableTetrisModel;
        this.tetrisView.setFocusable(true);
        this.tetrisView.addKeyListener(this);
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

        if (controllableTetrisModel.gameState() == GameState.ACTIVE_GAME){
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

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
