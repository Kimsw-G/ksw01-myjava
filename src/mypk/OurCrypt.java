package mypk;

import java.util.ArrayList;
import java.util.List;

public class OurCrypt {
    public static void main(String[] args) {
        OurCryptSolution ocs = new OurCryptSolution();
        System.out.println(ocs.solution("ybcde", "az", 1));
    }

}

class OurCryptSolution {

    public String solution(String s, String skip, int index) {
        String answer = "";
        List<Integer> checkCard = new ArrayList<>();
        for (int i = 0; i < skip.length(); i++) { // 여기 값을 통해서 감사
            checkCard.add((int)(skip.charAt(i)));
        }
        for(int i=0; i<s.length();i++){
            char ichar = s.charAt(i);
            for(int j=0;j<index;j++){  // index번 더해보기
                ichar++; // 값을 추가함
                if(ichar==123) ichar -= 26;
                if(checkCard.contains((int)ichar))j--; // 값이 포함되어있으면 값을 낮추기(스킵)
            }
            answer += ichar;
        }
        return answer;
    }
}