package no.uib.inf101.grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import no.uib.inf101.tetris.view.ColorTheme;

public class DefaultColorThemeTest {
    @Test
    public void sanityDefaultColorThemeTest() {
    ColorTheme colors = new ColorTheme();
    assertEquals(new Color(255, 255, 255), colors.getBackgroundColor());
    assertEquals(new Color(192, 192,192), colors.getFrameColor());
    assertEquals(Color.BLACK, colors.getCellColor('-'));
    assertEquals(Color.RED, colors.getCellColor('L'));
    assertThrows(IllegalArgumentException.class, () -> colors.getCellColor('\n'));
}
}
