package db.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import db.controller.MainController;

import java.awt.*;
import java.util.concurrent.Flow;

public class MainForm extends JFrame implements BaseForm{
    private static final long serialVersionUID = 1L;

    public static boolean flag = false;

    private JLabel lblMain;
    private JButton btnList;
    private JButton btnLogin;
    private JButton btnJoin;

    // test
    // public static void main(String[] args) {
    //     new MainForm();
    // }

    public MainForm(){
        int width=200;
        int height=50;
        int x=FRAME_WIDTH/2-width/2-10;
        int y=10;

        setTitle("Main Form");
        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lblMain = new JLabel("Main");
        lblMain.setFont(new Font("D2Coding", Font.PLAIN, 30));
        lblMain.setHorizontalAlignment(JLabel.CENTER);
        lblMain.setBounds(x,y,width,height);

        btnList = new JButton("리스트 보기");
        btnList.setEnabled(flag);
        btnList.setBounds(x, y+=height+10, width, height);

        btnLogin = new JButton("로그인");
        btnLogin.setBounds(x, y+=height+10, width, height);

        btnJoin = new JButton("회원가입");
        btnJoin.setBounds(x, y+=height+10, width, height);

        add(lblMain);
        add(btnList);
        add(btnLogin);
        add(btnJoin);
        
        btnList.addActionListener(e->{
            dispose();
            // System.out.println("Main to Login");
            MainController.getInstance().getController("List");
        });
        btnLogin.addActionListener(e->{
            dispose();
            // System.out.println("Main to Login");
            MainController.getInstance().getController("Login");
        });
        btnJoin.addActionListener(e->{
            dispose();
            // System.out.println("Main to Join");
            MainController.getInstance().getController("Join");
        });
        
        setVisible(true);
    }


}
