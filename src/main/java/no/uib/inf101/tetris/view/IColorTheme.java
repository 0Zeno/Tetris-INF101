package no.uib.inf101.tetris.view;

import java.awt.Color;

/**
 * The IColorTheme interface represents a color theme for a Tetris game.
 * It provides methods to retrieve different colors used in the game.
 */
public interface IColorTheme {

  /**
   * @param color the character representing the color of the cell
   * @return the color of the cell
   * @throws Error if the return value is null
   */
  Color getCellColor(Character color);

  /**
   * @return the color of the frame
   */
  Color getFrameColor();

  /**
   * @return the background color
   */
  Color getBackgroundColor();

  /**
   * @return the color for the "Game Over" message
   */
  Color getGameOverColor();
}
