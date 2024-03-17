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
            case '-' -> new Color(255, 255, 255, 90);
            default -> throw new IllegalArgumentException("No avalible color for '" + c + "'");
        };
        return color;
    }

    @Override
    public Color getFrameColor() {
        return new Color(0, 0, 0, 20);
    }

    @Override
    public Color getBackgroundColor() {
        return new Color(0, 0, 0, 20);
    }

    @Override
    public Color getGameOverColor() {
        return (new Color(0, 0, 0, 90));
    }

}
