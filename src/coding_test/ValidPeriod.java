package coding_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidPeriod {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] pre = {"2021.12.02 B", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        ValidPeriodSolution vps = new ValidPeriodSolution();
        System.out.println(Arrays.toString(vps.solution(today, terms, pre)));
    }
}

class ValidPeriodSolution{
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;

        List<Integer> answerList = new ArrayList<Integer>();
        Map<String,Integer> map = termsToMap(terms);

        int currentYear = Integer.parseInt(today.substring(0, 4));
        int currentMonth = Integer.parseInt(today.substring(5, 7));
        int currentDay = Integer.parseInt(today.substring(8, 10));
        for (int i = 0; i < privacies.length; i++) {
            String expiredDay = calcExpiredDay(privacies[i], map);
            int expYear = Integer.parseInt(expiredDay.substring(0, 4));
            int expMonth = Integer.parseInt(expiredDay.substring(4, 6));
            int expDay = Integer.parseInt(expiredDay.substring(6, 8));
            // System.out.print(expYear+" ");
            // System.out.print(expMonth+" ");
            // System.out.println(expDay);
            if (currentYear > expYear || 
            (currentYear == expYear && currentMonth > expMonth) || 
            (currentYear == expYear && currentMonth == expMonth && currentDay > expDay)) {
                answerList.add(i + 1);
            }
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public Map<String,Integer> termsToMap(String[] terms){ // terms를 map 형태로 저장
        Map<String,Integer> map = new HashMap();
        for (int i = 0; i < terms.length; i++) {
            String key = terms[i].substring(0,1);
            Integer value = Integer.parseInt(terms[i].substring(2));
            map.put(key, value);
        }

        return map;
    }
    public String calcExpiredDay(String privacie, Map<String,Integer> map){ // 만료 일자 구하기
        Integer year = Integer.parseInt(privacie.substring(0,4));
        Integer month = Integer.parseInt(privacie.substring(5,7));
        Integer day = Integer.parseInt(privacie.substring(8,10)) ;
        Integer term = map.get(privacie.substring(11));

        month+=term;
        while(month>12){
            year+=1;
            month-=12;
        }

        day-=1;
        if(day<=0){
            day+=28;
            month-=1;
            if(month==0){
                month+=12;
                year-=1;
            }
        }
        String result = ""+year;
        if(month<10) result +="0"+month;
        else result +=month;
        if(day<10) result +="0"+day;
        else result +=day;

        return result;
    }
}