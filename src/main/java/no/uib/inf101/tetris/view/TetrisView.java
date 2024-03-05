package no.uib.inf101.tetris.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import no.uib.inf101.grid.GridCell;

public class TetrisView extends JPanel {

    IViewbleTetrisModel tetrisModel;

    ColorTheme colorTheme;

    private static final double OUTERMARGIN = 10;

    private static final double INNERMARGIN = 1;

    public TetrisView(IViewbleTetrisModel vModel) {
        this.tetrisModel = vModel;
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(300, 400));
        this.colorTheme = new ColorTheme();

        Color bg = colorTheme.getBackgroundColor();

        this.setBackground(bg);
    }

    
    /**
     * 
     * @param g2 grafics element
     */
    private void drawGame(Graphics2D g2) {
        double width = getWidth();
        double height = getHeight();
        Rectangle2D background = new Rectangle2D.Double(OUTERMARGIN, OUTERMARGIN, width - 2 *OUTERMARGIN,
                height - 2 * OUTERMARGIN);
        CellPositionToPixelConverter cellInformation = new CellPositionToPixelConverter(background,
                tetrisModel.getDimentions(), INNERMARGIN);
        g2.setColor(colorTheme.getBackgroundColor());
        g2.fill(background);
        drawCells(g2, tetrisModel.getTilesOnBoard(), cellInformation, colorTheme);
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
