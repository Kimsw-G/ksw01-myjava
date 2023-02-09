package db.view;

import java.awt.Font;

import javax.swing.JLabel;

public class ViewConfig {
    public static void centerLable(JLabel jlabel) {
        centerLable(jlabel, "D2Coding", 30);
    }

    public static void centerLable(JLabel jlabel, String font) {
        centerLable(jlabel, font, 30);
    }

    public static void centerLable(JLabel jlabel, int size) {
        centerLable(jlabel, "D2Coding", size);
    }

    public static void centerLable(JLabel jlabel, String font, int size) {
        jlabel.setFont(new Font(font, Font.PLAIN, size));
        jlabel.setHorizontalAlignment(JLabel.CENTER);
    }
}
