package no.uib.inf101.tetris.view;

import java.awt.Color;

public interface IColorTheme {

  /**
   * 
   * @param color 
   * @return gets cell color
   * @throws Error if return value is null
   */
    Color getCellColor(Character color);

    /**
     * 
     * @return gets frame color
     */

    Color getFrameColor();


    /**
     * 
     * @return gets background color
     * @throws Error color can not be transparent
     */
    Color getBackgroundColor();
} 