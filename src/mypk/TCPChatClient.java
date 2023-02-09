package mypk;

import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TCPChatClient extends BaseFrm{
    final String DEFAULT_IP = "192.168.0.187";
    private Socket socket;
    private JTextArea ta;
    private JScrollPane scp;
    private JTextField tf;

    private DataOutputStream out;
    private String nickname;
    private String serverIP;

    protected TCPChatClient() {
        super("Chat",400,500);
        serverIP = JOptionPane.showInputDialog("Input Server IP", DEFAULT_IP);
        nickname = JOptionPane.showInputDialog("Nickname");
        try {
            socket = new Socket(serverIP, 7777);
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(nickname);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TCPChatClient();
    }

    @Override
    public void init(){
        ta = new JTextArea();
        scp = new JScrollPane(ta);
        tf = new JTextField();
        tf.setFont(new Font("맑은 고딕",Font.PLAIN, 16));
        tf.setFont(new Font("맑은 고딕",Font.PLAIN, 20));
        tf.addActionListener(e->{
            try {
                out.writeUTF(String.format("[%s] %s",nickname,tf.getText()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
    @Override
    public void arrange(){
        add(scp.CENTER_ALIGNMENT);
        
    }

    private class Receiver extends Thread {
        DataInputStream in;

        protected Receiver(Socket socket) {
            try {
                this.in = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ;
        }

        @Override
        public void run() {
            while (in != null) {
                try {
                    System.out.println(in.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
