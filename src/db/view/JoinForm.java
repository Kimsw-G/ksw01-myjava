package db.view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import db.controller.MainController;
import db.dao.MemberDao;
import db.entity.MemberEntity;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class JoinForm extends JFrame implements BaseForm{

    private JLabel lblJoin, lblMname, lblMid, lblMpass, lblMpassChk, lblMphone, lblGender, lblMale, lblFemale;
    private JTextField txtMname, txtMid;
    private JPasswordField txtMpass, txtMpassChk;
    private JTextField[] txtMphone;
    private ButtonGroup grpGender;
    private JRadioButton[] radioGender;
    private JButton btnJoin, btnCancel;

    private MemberDao memberDao = new MemberDao();

    // public static void main(String[] args) {
    //     new JoinForm();
    // }

    public JoinForm() {
        int height=30;

        int headWidth=200;
        int headX=FRAME_WIDTH/2-headWidth/2-10;
        int headY=10;

        int labelWidht=100;
        int labelX=50;
        int labelY=headY+height+5;

        int textWidht = 250;
        
        setTitle("Join From");
        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT+50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        lblJoin = new JLabel("Join");
        ViewConfig.centerLable(lblJoin);
        lblJoin.setBounds(headX,headY,headWidth,height);

        // NAME
        lblMname = new JLabel("이름");
        ViewConfig.centerLable(lblMname,15);
        lblMname.setBounds(labelX,labelY,labelWidht,height);

        txtMname = new JTextField();
        txtMname.setBounds(labelX+labelWidht+10,labelY,textWidht,height);
        
        // ID
        lblMid = new JLabel("아이디");
        ViewConfig.centerLable(lblMid,15);
        lblMid.setBounds(labelX,labelY+=height+5,labelWidht,height);

        txtMid = new JTextField();
        txtMid.setBounds(labelX+labelWidht+10,labelY,textWidht,height);

        // PW
        lblMpass = new JLabel("패스워드");
        ViewConfig.centerLable(lblMpass,15);
        lblMpass.setBounds(labelX,labelY+=height+5,labelWidht,height);

        txtMpass = new JPasswordField();
        txtMpass.setBounds(labelX+labelWidht+10,labelY,textWidht,height);

        // PWCHK
        lblMpassChk = new JLabel("패스워드검사");
        ViewConfig.centerLable(lblMpassChk,15);
        lblMpassChk.setBounds(labelX,labelY+=height+5,labelWidht,height);

        txtMpassChk = new JPasswordField();
        txtMpassChk.setBounds(labelX+labelWidht+10,labelY,textWidht,height);
        
        // PHONE
        lblMphone = new JLabel("전화번호");
        ViewConfig.centerLable(lblMphone,15);
        lblMphone.setBounds(labelX,labelY+=height+5,labelWidht,height);
        
        txtMphone = new JTextField[3];
        for (int i = 0; i < txtMphone.length; i++) {
            txtMphone[i] = new JTextField();
            txtMphone[i].setBounds(labelX+labelWidht+10+(i*textWidht/3),labelY,textWidht/3,height);
            add(txtMphone[i]);
        }

        lblGender = new JLabel("성별");
        ViewConfig.centerLable(lblGender,15);
        lblGender.setBounds(labelX,labelY+=height+5,labelWidht,height);

        lblMale = new JLabel("남자");
        ViewConfig.centerLable(lblMale,15);
        lblFemale = new JLabel("여자");
        ViewConfig.centerLable(lblFemale,15);

        grpGender = new ButtonGroup();
        radioGender = new JRadioButton[2];
        radioGender[0] = new JRadioButton("1");
        radioGender[1] = new JRadioButton("0");
        grpGender.add(radioGender[0]);
        grpGender.add(radioGender[1]);
        radioGender[0].setBounds(labelX+labelWidht+10,labelY,20,height);
        lblMale.setBounds(labelX+labelWidht+10,labelY,textWidht/2,height);
        radioGender[1].setBounds(labelX+labelWidht+10+textWidht/2,labelY,20,height);
        lblFemale.setBounds(labelX+labelWidht+10+textWidht/2,labelY,textWidht/3,height);
        radioGender[0].setSelected(true);

        btnJoin = new JButton("회원가입");
        btnJoin.setBounds(headX,labelY+=height+5,headWidth/2-10,height);

        btnCancel = new JButton("취소");
        btnCancel.setBounds(headX+headWidth/2+10,labelY,headWidth/2-10,height);

        add(lblJoin);

        add(lblMname);
        add(txtMname);

        add(lblMid);
        add(txtMid);
        
        add(lblMpass);
        add(txtMpass);

        add(lblMpassChk);
        add(txtMpassChk);

        add(lblMphone);

        add(lblGender);
        add(lblMale);
        add(lblFemale);
        add(radioGender[0]);
        add(radioGender[1]);

        add(btnJoin);
        add(btnCancel);

        btnJoin.addActionListener(e->{
            String mname = txtMname.getText().trim();
            String mid = txtMid.getText().trim();
            String mpass = new String(txtMpass.getPassword()).trim();
            String mpassChk = new String(txtMpassChk.getPassword()).trim();
            String mphone = txtMphone[0].getText().trim() + txtMphone[1].getText().trim() + txtMphone[2].getText().trim();
            String gender = radioGender[0].isSelected()?radioGender[0].getText().trim():radioGender[1].getText().trim();
            boolean blankChk = mname.equals("") || mid.equals("") || mpass.equals("") || mpassChk.equals("") || mphone.equals("") || gender.equals("");
            if (blankChk) {
                JOptionPane.showMessageDialog(btnJoin, "빈값이 있어요");
            }else if(!mpass.equals(mpassChk)){
                JOptionPane.showMessageDialog(btnJoin, "비밀번호가 일치하지 않아요");
            }
            MemberEntity memberEntity = new MemberEntity(mname, mid, mpass, mphone, gender);
            System.out.println(memberEntity);
            try{
                memberDao.join(memberEntity);
                dispose();
                new MainForm();
            }catch(SQLException error){
                JOptionPane.showMessageDialog(btnJoin, "에러 발생! : "+error.getStackTrace());
                error.printStackTrace();
            }
        });
        btnCancel.addActionListener(e->{
            dispose();
            MainController.getInstance().getController("Main");
        });
        

        setVisible(true);
    }

    


}