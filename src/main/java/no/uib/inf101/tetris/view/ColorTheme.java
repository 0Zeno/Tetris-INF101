package no.uib.inf101.tetris.view;

import java.awt.Color;

public class ColorTheme implements IColorTheme {

    @Override
    public Color getCellColor(Character c) {
        Color color = switch (c) {
            case 'L' -> Color.RED;
            case 'J' -> Color.GREEN;
            case 'S' -> Color.BLUE;
            case 'Z' -> Color.YELLOW;
            case 'I' -> Color.ORANGE;
            case 'O' -> Color.PINK;
            case 'T' -> Color.MAGENTA;
            case 'U' -> Color.LIGHT_GRAY;
            case '-' -> new Color(0, 0, 0, 50);
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

    @Override
    public Color getGameOverColor() {
        return (new Color(20, 20, 20, 200));
    }

}
