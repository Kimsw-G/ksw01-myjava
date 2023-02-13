package mypk;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewChat {
    private Socket socket;
    private DataOutputStream out;
    private JTextArea textArea; // Receiver에서 사용하기 위해 전역변수로 설정
    private static final String DEFAULT_IP = "192.168.0.187";

    public static void main(String[] args) {
        String serverIP = JOptionPane.showInputDialog("Input Server IP", DEFAULT_IP);
        String nickname = JOptionPane.showInputDialog("Nickname");
        if (nickname == null) {
            return;
        } else if (nickname.isEmpty()) {
            System.out.println("빈값");
        } else {
            System.out.println("굿");
        }

        new NewChat().init(serverIP, nickname);
    }

    public void init(String serverIP, String nickname) {
        JFrame frame = new JFrame("Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        panel.add(textField, BorderLayout.CENTER);

        JButton btnSend = new JButton("Send");
        panel.add(btnSend, BorderLayout.EAST);

        frame.setVisible(true);

        try {
            socket = new Socket(serverIP, 7777);
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(nickname);

            Receiver receiver = new Receiver(socket);
            receiver.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    out.writeUTF(String.format("[%s] %s", nickname, textField.getText()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                textField.setText("");
            }
        });
    }

    class Receiver extends Thread {
        DataInputStream in;
        Socket socket;

        protected Receiver(Socket socket) {
            try {
                this.in = new DataInputStream(socket.getInputStream());
                this.socket = socket;
            } catch (IOException e) {
                e.printStackTrace();
            }
            ;
        }

        @Override
        public void run() {
            while (in != null) {
                try {
                    textArea.append(in.readUTF() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}