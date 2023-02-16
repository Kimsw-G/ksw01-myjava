package coding_test;

public class MBTI {
    public static void main(String[] args) {
        String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
        // String[] survey = {"TR", "RT", "TR"};
        int[] choice = { 5, 3, 2, 7, 5 };
        // int[] choice = { 7, 1, 3 };
        MBTISol s = new MBTISol();
        System.out.println(s.solution(survey, choice));
    }

}

class MBTISol {
    private String[] SURVEY = { "RT", "TR", "CF", "FC", "JM", "MJ", "AN", "NA" };
    private String answers = "RTCFJMAN";
    private int[] scores = new int[4];

    // R T
    // C F
    // J M
    // A N
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        for (int i = 0; i < choices.length; i++) {
            choices[i] -= 4;
        }
        for (int i = 0; i < choices.length; i++) {
            if(survey[i].equals(SURVEY[0])){
                scores[0] += choices[i];
            }else if(survey[i].equals(SURVEY[1])){
                scores[0] -= choices[i];
            }else if(survey[i].equals(SURVEY[2])){
                scores[1] += choices[i];
            }else if(survey[i].equals(SURVEY[3])){
                scores[1] -= choices[i];
            }else if(survey[i].equals(SURVEY[4])){
                scores[2] += choices[i];
            }else if(survey[i].equals(SURVEY[5])){
                scores[2] -= choices[i];
            }else if(survey[i].equals(SURVEY[6])){
                scores[3] += choices[i];
            }else if(survey[i].equals(SURVEY[7])){
                scores[3] -= choices[i];
            }
        }
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
            if(scores[i]>0){
                answer+=answers.charAt(i*2+1);
            }else{
                answer+=answers.charAt(i*2);
            }
        }
        return answer;
    }
}