package no.uib.inf101.tetris.view;

import java.awt.Color;

public class ColorTheme implements IColorTheme {

    @Override
    public Color getCellColor(Character c) {
        Color color = switch(c) {
            case 'r' -> Color.RED;
            case 'g' -> Color.GREEN;
            case 'b' -> Color.BLUE;
            case 'y' -> Color.YELLOW;
            case 'o' -> Color.ORANGE;
            case 'p' -> Color.PINK;
            case '-' -> Color.BLACK;
            default -> throw new IllegalArgumentException("No avalible color for '" + c + "'");
        };
        return color;
    }

    @Override
    public Color getFrameColor() {
        return Color.LIGHT_GRAY;
    }

    @Override
    public Color getBackgroundColor() {
        return Color.WHITE;
    }
    
}
