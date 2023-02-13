package coding_test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 프로그래머스 lv2 숫자 카드 나누기
public class Solution02_numcard {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        answer = getBigger(getSol(arrayA, arrayB), getSol(arrayB, arrayA));
        return answer;
    }

    public int getBigger(int a, int b){
        if(a>b) return a;
        else return b;
    }

    public int getSol(int[] arrayA, int[] arrayB){
        int answer = 0;
        List<Integer> list = getD(arrayA[0]);
        for(int i=1; i<arrayA.length;i++){
            list = getCD(list, arrayA[i]);
        }
        // 거꾸로 뒤집어서 0번째부터 검사
        Collections.reverse(list);
        System.out.println(list);
        // 모든 수에대해 검사 실시
        for(Integer i:list){
            if(!checkD(i, arrayB)){ // 약수가 없다면?
                return i;
            }
        }
        return answer;
    }
    
    // 약수 구하기
    public List<Integer> getD(int num){
        List<Integer> dList = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if(num%i==0) dList.add(i);
        }
        return dList;
    }
    // dList를 이용한 공약수 구하기
    public List<Integer> getCD(List<Integer> dList, int num){
        List<Integer> cdList = new ArrayList<>();
        for (Integer i : dList) {
            if(num%i==0) cdList.add(i);
        }
        return cdList;
    }
    // arrayB 의 수가 약수 d를 가지는지 확인
    public boolean checkD(int d, int[] arrayB){
        for (int i : arrayB) {
            if(i%d==0) return true; // 약수 없음
        }
        return false; // 약수 있음
    }
}
