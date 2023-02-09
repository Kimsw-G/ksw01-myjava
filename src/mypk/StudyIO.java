package mypk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class StudyIO{
    public static void main(String[] args) {
        byte[] inSRC = {0,1,2,3,4,5,6,7};
        byte[] outsrc = null;
        byte[] tmp = new byte[4];

        var inputStream = new ByteArrayInputStream(inSRC);
        var outputStream = new ByteArrayOutputStream();
        System.out.println(Arrays.toString(inSRC));
        try{
            while(inputStream.available() > 0){
                int length = inputStream.read(tmp);
                outputStream.write(tmp,0,length);
                outsrc = outputStream.toByteArray();
                System.out.println("tmp : "+Arrays.toString(tmp));
                System.out.println("outsrc : "+Arrays.toString(outsrc));
            }
        }catch(Exception e ){}
    }
}