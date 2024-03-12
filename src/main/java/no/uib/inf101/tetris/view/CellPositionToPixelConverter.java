package no.uib.inf101.tetris.view;

import java.awt.geom.Rectangle2D;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridDimension;

public class CellPositionToPixelConverter {
    private Rectangle2D box;
    private GridDimension gd;
    private double margin;

    public CellPositionToPixelConverter(Rectangle2D box, GridDimension gd, double margin){
        this.gd = gd;
        this.box = box;
        this.margin = margin;
    }

    
    /** 
     * @param cp
     * @return Rectangle2D
     */
    public Rectangle2D getBoundsForCell(CellPosition cp){
        double rows = gd.rows();
        double cols = gd.cols();

        double boxWidth = this.box.getWidth();
        double boxHeight = this.box.getHeight();

        double boxX = this.box.getX();
        double boxY = this.box.getY();

        double margin = this.margin;

        double cellHeight = (boxHeight - (margin * (rows + 1))) / rows;
        double cellWidth = (boxWidth - (margin * (cols + 1))) / cols;

        double row = cp.row();
        double col = cp.col();

        double cellY = boxY + row * cellHeight + margin * (row + 1);
        double cellX = boxX + col * cellWidth + margin * (col + 1);

        return new Rectangle2D.Double(cellX, cellY, cellWidth, cellHeight);
    }
}
