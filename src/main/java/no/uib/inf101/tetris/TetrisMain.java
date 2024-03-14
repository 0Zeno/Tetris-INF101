package no.uib.inf101.tetris;

import javax.swing.JFrame;

import no.uib.inf101.tetris.controller.TetrisController;
import no.uib.inf101.tetris.model.TetrisBoard;
import no.uib.inf101.tetris.model.TetrisModel;
import no.uib.inf101.tetris.model.Tetromino.ITetrominoFactory;
import no.uib.inf101.tetris.model.Tetromino.RandomTetrominoFactory;
import no.uib.inf101.tetris.view.TetrisView;


public class TetrisMain {

  public static final String WINDOW_TITLE = "INF101 Tetris";
  
  
  /** 
   * @param args
   */
  public static void main(String[] args) {
    TetrisBoard tb = new TetrisBoard(20, 10);
    ITetrominoFactory factory = new RandomTetrominoFactory();

    TetrisModel model = new TetrisModel(tb, factory);
    
    TetrisView view = new TetrisView(model);
    @SuppressWarnings("unused")
    TetrisController controller = new TetrisController(model, view);
    // The JFrame is the "root" application window.
    // We here set som properties of the main window, 
    // and tell it to display our tetrisView
    JFrame frame = new JFrame(WINDOW_TITLE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Here we set which component to view in our window
    frame.setContentPane(view);
    frame.setLocationRelativeTo(null);
    
    // Call these methods to actually display the window
    frame.pack();
    //setter rammen i midten
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    

  }
  
}
