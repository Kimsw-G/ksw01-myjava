package mypk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TCPChat {
    HashMap<String, DataOutputStream> clients;
    public static void main(String[] args) {
        new TCPChat().start();
    }

    protected TCPChat(){
        clients = new HashMap<>();
        Collections.synchronizedMap(clients);
    }

    private void start() {
        ServerSocket ss = null;
        Socket socket = null;
        try {
            ss = new ServerSocket(7777);
            System.out.println("Running");
            while (true) {
                socket = ss.accept();
                System.out.printf("[%s:%s] is accepted", socket.getInetAddress(), socket.getPort());
                new ServerReceiver(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        protected ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String nname = "";
            try {
                nname = in.readUTF();
                if(clients.containsKey(nname)){
                    clients.put(nname, out);
                }else{
                    out.writeUTF("exit name");
                    return;
                }
                sendToAll(String.format("[%s]가 들어옴", nname));
                while(in!=null){
                    sendToAll(in.readUTF());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                clients.remove(nname);
                sendToAll(String.format("[%s]가 나감", nname));

            }
            super.run();
        }
        private void sendToAll(String msg){
            Iterator<String> it = clients.keySet().iterator();
            while(it.hasNext()){
                try {
                    out.writeUTF(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
