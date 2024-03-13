package no.uib.inf101.tetris.view;

import java.awt.Color;

public class ColorTheme implements IColorTheme {

    
    /** 
     * @param c
     * @return Color
     */
    @Override
    public Color getCellColor(Character c) {
        Color color = switch(c) {
            case 'L' -> Color.RED;
            case 'J' -> Color.GREEN;
            case 'S' -> Color.BLUE;
            case 'Z' -> Color.YELLOW;
            case 'I' -> Color.ORANGE;
            case 'O' -> Color.PINK;
            case 'T' -> Color.MAGENTA;
            case '-' -> Color.BLACK;
            default -> throw new IllegalArgumentException("No avalible color for '" + c + "'");
        };
        return color;
    }

    
    /** 
     * @return Color
     */
    @Override
    public Color getFrameColor() {
        return Color.LIGHT_GRAY;
    }

    @Override
    public Color getBackgroundColor() {
        return Color.WHITE;
    }


    @Override
    public Color getGameOverColor() {
        return (new Color(20, 20, 20, 200));
    }
    

    
}
