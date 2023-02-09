package mypk;

import java.util.Arrays;
import java.util.PriorityQueue;

public class WinnerLeague {
    public static void main(String[] args) {
        int k = 9;
        int[] scores = {10, 30, 40, 3, 0, 20, 4};
        // WinnerLeagueSolution wls = new WinnerLeagueSolution();
        // System.out.println(Arrays.toString(wls.solution(k,scores)));
        WinnerLeagueEasy wle = new WinnerLeagueEasy();
        System.out.println(Arrays.toString(wle.solution(k,scores)));
    }
}
class WinnerLeagueEasy{
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length]; // 점수 길이만큼의 배열 선언
        int answerCnt = 0; // answer 배열에 값을 넣기위한 idx값
        int[] league = new int[k];
        
        for (int i = 0; i < k; i++) {
            try {
                league[0] = score[i];
                Arrays.sort(league);
                answer[answerCnt++] = league[k-i-1];
            } catch (Exception e) { break;}
        } // 1번~k번까지 값을 추가
        for (int i = k; i < score.length; i++) { // 
            Arrays.sort(league);// 정룔 후
            if(league[0] < score[i]){ // 기존 최솟값보다 신규값이 작으면?? => 변경
                league[0] = score[i];
            }
            Arrays.sort(league);
            answer[answerCnt++] = league[0];
        }

        return answer;
    }

}
// 1. 값을 배열(전당)에 추가한다
// 2. 꼴지를 퇴출
// 3. 제일 낮은 멤버를 출력
class WinnerLeagueSolution{
    
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length]; // 점수 길이만큼의 배열 선언
        int answerCnt = 0; // answer 배열에 값을 넣기위한 idx값
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // 명예의 전당을 선언하기위한 값
        
        for (Integer sc : score) {
            pq.offer(sc); // pq에 값을 추가
            if(pq.size()==(k+1)){ // pq에 인원이 k+1명 있을 경우
                pq.poll(); // pq의 최솟값을 삭제
                // printPQ(pq);
            }
            answer[answerCnt++] = getMinPQ(k, pq); // answer에 pq의 최솟값을 추가
        }
        return answer;
    }
    public <T> T getMinPQ(int k,PriorityQueue<T> pq){ // pq의 최솟값을 구하기 위한 메소드
        Object[] array = pq.toArray();
        return (T)array[0];
    }

    // 테스트용코드
    public <T> void printPQ(PriorityQueue<T> pq){
        System.out.println("good");
        for (T t : pq) {
            System.out.print(t + ",");
        }
        System.out.println();
    }
}