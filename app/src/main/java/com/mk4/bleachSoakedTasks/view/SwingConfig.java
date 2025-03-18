package com.mk4.bleachSoakedTasks.view;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * A helper to manage Swing configurations
 * @author Arthur de Souza Manske
 */
public final class SwingConfig {
    public static String setFlatLafTheme(boolean darkTheme, Color accent)
    {
        final FlatLaf theme = (darkTheme ? new FlatDarculaLaf() : new FlatLightLaf());

        try {
            UIManager.setLookAndFeel(theme);
            return null;
        } catch (UnsupportedLookAndFeelException e) {
            return e.getLocalizedMessage();
        }
    }
}
