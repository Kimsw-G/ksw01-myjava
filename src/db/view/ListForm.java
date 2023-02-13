package db.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import db.controller.MainController;
import db.dao.MemberDao;
import db.entity.MemberEntity;

public class ListForm extends JFrame implements BaseForm {
    private static final long serialVersionUID = 1L;

    private JLabel lblList;
    private JPanel panMember;
    private JTable tblMember;

    private MemberDao memberDao = new MemberDao();

    public static void main(String[] args) {
        new ListForm();
    }

    public ListForm() {
        int width = 200;
        int height = 30;
        int x = FRAME_WIDTH - width / 2 - 10;
        int y = 10;

        setTitle("List Form");
        setLayout(null);
        setSize(FRAME_WIDTH * 2, FRAME_HEIGHT * 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lblList = new JLabel("Login");
        ViewConfig.centerLable(lblList);
        lblList.setBounds(x, y, width, height);

        List<MemberEntity> memberList = memberDao.findAllMember();
        String[] headerArray = { "회원번호", "이름", "아이디", "전화번호", "성별" };
        String[][] memberArray = new String[memberList.size()][headerArray.length];
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println(memberList.get(i).toString());
            memberArray[i][0] = Integer.toString(memberList.get(i).getMno());
            memberArray[i][1] = memberList.get(i).getMname();
            memberArray[i][2] = memberList.get(i).getMid();
            memberArray[i][3] = memberList.get(i).getMphone();
            memberArray[i][4] = memberList.get(i).getMgender();
        }
        TableModel tableModel = new DefaultTableModel(memberArray, headerArray);

        panMember = new JPanel();
        for (int i = 0; i < headerArray.length; i++) {
            panMember.add(new JLabel(headerArray[i]));
        }
        panMember.setBounds(x, y += height + 10, width, height);

        tblMember = new JTable();
        tblMember.setModel(tableModel);

        JTableHeader header = tblMember.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30));
        header.setBounds(0, y += height + 10, FRAME_WIDTH * 2, 30);
        tblMember.setTableHeader(header);
        tblMember.setFont(new Font("D2Coding", Font.PLAIN, 15));
        tblMember.setRowHeight(20);
        tblMember.setBounds(0, y += height, FRAME_WIDTH * 2, 20 * memberList.size());

        panMember.add(header);

        add(lblList);
        add(panMember);
        add(header);
        add(tblMember);
        tblMember.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblMember.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tblMember.getSelectedRow() != -1) {
                    int mno = Integer.parseInt((String)tblMember.getValueAt(tblMember.getSelectedRow(), 0));
                    System.out.println("pk : " + mno);
                    // System.out.println("Main to Login");
                    dispose();
                    MainController.getInstance().getController("Update",mno);
                }
            }
        });

        setVisible(true);

    }

}
