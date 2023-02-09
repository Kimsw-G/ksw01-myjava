package coding;

// 프로그래머스 lv2 점찍기
public class Solution01_dot {

    public long solution(int k, int d){
        long answer = 0;
        for(int i=0;i<=d;i+=k){
            answer+=calcPossible(calcDistance((long)i, (long)d),k);
        }
        return answer;
    }
    // 1) 아이디어
    public int calcDistance(long i, long d){ 
        long i2 = i*i;
        long d2 = d*d;
        return (int)(Math.sqrt(d2 - i2));
    }
    // 2) 아이디어
    // 이때 0좌표를 포함하므로 +1
    public int calcPossible(int distance, int k){ 
        return distance/k +1;
    }
}
