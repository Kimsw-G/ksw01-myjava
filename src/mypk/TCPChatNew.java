package mypk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TCPChatNew {

    public static void main(String[] args) {
        final String DEFAULT_IP = "192.168.0.187";
        String serverIP = JOptionPane.showInputDialog("Input Server IP", DEFAULT_IP);
        String nickname = JOptionPane.showInputDialog("Nickname");
        Socket socket;
        DataOutputStream out;
        Scanner s = new Scanner(System.in);
        DataOutputStream dos;

        
        try {
            socket = new Socket(serverIP, 7777);
            Receivers receiver = new Receivers(socket);
            receiver.start();
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(nickname);
            while(dos != null){
                dos.writeUTF(String.format("[%s] %s", nickname, s.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

class Receivers extends Thread {
    DataInputStream in;
    Socket socket;

    protected Receivers(Socket socket) {
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
                System.out.println(in.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}