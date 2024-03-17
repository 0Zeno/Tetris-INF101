package no.uib.inf101.tetris.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.tetris.model.GameState;

public class TetrisView extends JPanel {

    private IViewableTetrisModel tetrisModel;
    private ColorTheme colorTheme;
    private static final double OUTERMARGIN = 10;
    private static final double INNERMARGIN = 1;

    public TetrisView(IViewableTetrisModel vModel) {
        this.tetrisModel = vModel;
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(300, 600));
        this.colorTheme = new ColorTheme();

        Color bg = colorTheme.getBackgroundColor();

        this.setBackground(bg);
    }

    /**
     * Draws the game over screen on the graphics context.
     * 
     * @param g2 the graphics context to draw on
     * @param r2 the rectangle defining the area to draw the game over screen on
     */
    public void drawGameOver(Graphics2D g2, Rectangle2D r2) {
        if (tetrisModel.gameState() == GameState.GAME_OVER) {
            Rectangle2D gameOverScreen = r2;
            g2.setColor(colorTheme.getGameOverColor());
            g2.fill(gameOverScreen);
            g2.setColor(Color.LIGHT_GRAY);
            g2.setFont(new Font("Arial", Font.BOLD, 40));
            g2.drawString("Game Over", getHeight() / 12, getHeight() / 2);
        }
    }

    /**
     * 
     * @param g2 the graphics context to draw on
     */
    private void drawGame(Graphics2D g2) {
        double width = getHeight() / 2;
        double height = getHeight();
        Rectangle2D background = new Rectangle2D.Double(OUTERMARGIN, OUTERMARGIN, width - 2 * OUTERMARGIN,
                height - 2 * OUTERMARGIN);
        CellPositionToPixelConverter cellInformation = new CellPositionToPixelConverter(background,
                tetrisModel.getDimensions(), INNERMARGIN);

        g2.setColor(colorTheme.getBackgroundColor());
        g2.fill(background);
        drawCells(g2, tetrisModel.getTilesOnBoard(), cellInformation, colorTheme);
        drawCells(g2, tetrisModel.fallingTetromino(), cellInformation, colorTheme);

        if (tetrisModel.gameState() == GameState.GAME_OVER) {
            drawGameOver(g2, background);
        }
    }

    /**
     * 
     * @param g2 2d graphics
     * @param grid ittereble grid
     * @param cPConcverter cell position to graphics converter
     * @param colorTheme color theme of tetris
     */
    private static void drawCells(Graphics2D g2, Iterable<GridCell<Character>> grid,
            CellPositionToPixelConverter cPConcverter, ColorTheme colorTheme) {
        for (GridCell<Character> gridCell : grid) {
            Rectangle2D box = cPConcverter.getBoundsForCell(gridCell.pos());
            Color color = colorTheme.getCellColor(gridCell.value());
            g2.setColor(color);
            g2.fill(box);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGame(g2);
    }

}
