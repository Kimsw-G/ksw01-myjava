package mypk;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

public class Imsi {
    public static void main(String[] args) {
        // new MyFrame();
        int a = 0;
        try {
            a = 10;
            throw new Exception();
        } catch (Exception e) {
        }
        System.out.println(a);
    }
}

class MyFrame extends JFrame{

    public MyFrame() {
        
        setTitle("banana");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    
    
}