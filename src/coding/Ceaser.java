package coding;

public class Ceaser {
    public static void main(String[] args) {
        
    }
}

class CeaserSoltuion{
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0; i<s.length();i++){
            char myChar = s.charAt(i);
            if(myChar>='A'&&myChar<='Z'){ // 대문자일때
                myChar += n;
                if(myChar>'Z') myChar -= 26;
            }else if(myChar>='a'&&myChar<='z'){ 
                myChar += n;
                if(myChar>'z') myChar -= 26;
            }
            answer += myChar;
        }
        return answer;
    }

    
}