package mypk;

import java.util.Arrays;
import java.util.HashMap;

public class NearWord {
    public static void main(String[] args) {
        NearWordSolution sol = new NearWordSolution();
        System.out.println(Arrays.toString(sol.solution("banana")));
    }
}

class NearWordSolution{
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int answerCnt = 0;
        HashMap<String,Integer> map = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            String checkString = Character.toString(s.charAt(i));
            Integer near = map.get(checkString);
            if(near==null){
                map.put(checkString, i);
                answer[answerCnt++] = -1;
            }else{
                answer[answerCnt++] = i-near;
                map.put(checkString,i);
            }
        }
        return answer;
    }
    // 단어 검사
    // 단어를 검색(리스트에서)
    // 단어를 리스트에 저장
    
}