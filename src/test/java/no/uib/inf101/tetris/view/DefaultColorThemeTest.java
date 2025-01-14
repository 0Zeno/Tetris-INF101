package no.uib.inf101.tetris.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;

import org.junit.jupiter.api.Test;


public class DefaultColorThemeTest {
    @Test
    public void sanityDefaultColorThemeTest() {
    ColorTheme colors = new ColorTheme();
    assertEquals(new Color(0, 0, 0, 20), colors.getBackgroundColor());
    assertEquals(new Color(0, 0, 0, 20), colors.getFrameColor());
    assertEquals(new Color(255, 255, 255, 90), colors.getCellColor('-'));
    assertEquals(Color.RED, colors.getCellColor('L'));
    assertThrows(IllegalArgumentException.class, () -> colors.getCellColor('\n'));
}
}
