package no.uib.inf101.tetris;

import javax.swing.JFrame;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.tetris.model.TetrisBoard;
import no.uib.inf101.tetris.model.TetrisModel;
import no.uib.inf101.tetris.view.TetrisView;


public class TetrisMain {
  public static final String WINDOW_TITLE = "INF101 Tetris";
  
  public static void main(String[] args) {
    TetrisBoard tb = new TetrisBoard(20, 10);
    TetrisModel model = new TetrisModel(tb);
    tb.set(new CellPosition(0, 0), 'g');
    tb.set(new CellPosition(0, 9), 'y');
    tb.set(new CellPosition(19, 0), 'r');
    tb.set(new CellPosition(19, 9), 'b');
    TetrisView view = new TetrisView(model);
    
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
