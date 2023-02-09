package db.view;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.controller.MainController;
import db.doa.MemberDao;
import db.entity.MemberEntity;

public class LoginForm extends JFrame implements BaseForm{
    private static final long serialVersionUID = 1L;

    private JLabel lblLogin;
    private JTextField txtMid;
    private JPasswordField txtMpass;
    private JButton btnLogin,btnJoin,btnCancel;

    private MemberDao memberDao = new MemberDao();

    public static void main(String[] args) {
        new LoginForm();
    }

    public LoginForm() {
        int width=200;
        int height=30;
        int x=FRAME_WIDTH/2-width/2-10;
        int y=10;

        setTitle("Login Form");
        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lblLogin = new JLabel("Login");
        ViewConfig.centerLable(lblLogin);
        lblLogin.setBounds(x,y,width,height);


        txtMid = new JTextField();
        txtMid.setPreferredSize(new Dimension(150, 25));
        txtMid.setBounds(x, y+=height+10, width, height);

        txtMpass = new JPasswordField();
        txtMpass.setPreferredSize(new Dimension(150, 25));
        txtMpass.setBounds(x, y+=height+10, width, height);

        btnLogin = new JButton("로그인");
        btnLogin.setBounds(x, y+=height+10, width, height);

        btnJoin = new JButton("회원가입");
        btnJoin.setBounds(x, y+=height+10, width/2-10, height);

        btnCancel = new JButton("취소");
        btnCancel.setBounds(x+width/2+10, y, width/2-10, height);

        add(lblLogin);
        add(txtMid);
        add(txtMpass);
        add(btnLogin);
        add(btnJoin);
        add(btnCancel);

        btnLogin.addActionListener(e->{
            String mid = txtMid.getText();
            String mPass = new String(txtMpass.getPassword());
            try {
                MemberEntity memberEntity = memberDao.loginCheck(mid, mPass);
                if (memberEntity == null) throw new AccountException();
                dispose();
                MainForm.flag = true;
                new MainForm();
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(btnJoin, "에러 발생! : "+error.getStackTrace());
                error.printStackTrace();
            } catch (AccountException error){
                JOptionPane.showMessageDialog(btnJoin, "계정을 확인하세요");
            }
        });

        btnJoin.addActionListener(e->{
            dispose();
            MainController.getInstance().getController("Join");
        });
        
        btnCancel.addActionListener(e->{
            dispose();
            MainController.getInstance().getController("Main");
        });

        setVisible(true);
    }
    private class AccountException extends RuntimeException{
        AccountException(){
            super("계정이 에러");
        }
    }
}
