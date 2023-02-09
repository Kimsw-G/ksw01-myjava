package mypk;

import javax.swing.*;

public class BaseFrm extends JFrame {
    protected BaseFrm(String title, int width, int height) {
        super(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }

    public void init() {
        // This method can be overridden by the child classes to add their own components.
    }
}
