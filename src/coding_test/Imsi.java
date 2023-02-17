package coding_test;

import java.util.*;
import java.util.Map.Entry;

public class Imsi {
    public static void main(String[] args) {
        int[][] info = { { -1, -2 }, { -2, -1 }, { 1, 2 }, { 2, 1 } };
        ImsiSolution s = new ImsiSolution();

        // System.out.println(Arrays.toString(s.solution(info)));
        // System.out.println(s.solution("AAAAE"));
        // System.out.println(s.plusHexadecimal("45555"));
        s.configData();
        System.out.println(s.wordToNum("AAAE"));

    }
}

class ImsiSolution {
    Character[] datas = { ' ', 'A', 'E', 'I', 'O', 'U' };
    List<Character> dataList = Arrays.asList(datas);
    List<String> list;

    public int solution(String word) {
        int answer = 0;

        return answer;
    }

    public void configData() {
        list = new ArrayList<String>();
        String str = "00000";
        while(!str.equals("01112")){
            list.add(str);
            str = plusHexadecimal(str);
            System.out.println(str);
        }
    }
    public String plusHexadecimal(String hexadecimal){
        int iVal = Integer.parseInt(hexadecimal);
        iVal++;
        hexadecimal = String.format("%05d",iVal);
        while(hexadecimal.contains("6")){
            char[] hex = hexadecimal.toCharArray();
            hex[hexadecimal.indexOf("6")] = '0';
            hex[hexadecimal.indexOf("6")-1] +=1;
            hexadecimal = new String(hex);
        }
        return hexadecimal;
    }
    // 00000
    // 00001
    public String wordToNum(String str){
        String result = "";
        for (char c : str.toCharArray()) {
            result += dataList.indexOf(c);
        }
        return result;
    }

}