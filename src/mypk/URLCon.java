package mypk;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URL;

public class URLCon {
    public static void main(String[] args) {
        URL url = null;
        BufferedReader input = null;
        String address = "https://www.naver.com";
        String line = "";

        try {
            url = new URL(address);
            input = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
            while((line=input.readLine())!=null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
