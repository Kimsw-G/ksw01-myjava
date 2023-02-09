package coding;
import java.util.Arrays;

public class Solution06_arrow {
    final int MAX_SCORE = 10;
    public int[] solution(int n, int[] info) {
        int[] answer = new int[info.length];
        double[] values = getValues(info);
        boolean toggle = false;
        // System.out.println(Arrays.toString(values));
        while(true){
            int idx = getBiggestIndex(values);
            // System.out.println(idx);
            if(idx==-1) break;
            if(info[idx]+1 > n){ // 화살이 모자란다
                values[idx] = 0;
                continue;
            }
            toggle = true;
            answer[idx] = info[idx]+1;
            n-=info[idx]+1;
            values[idx] = 0;
            info[idx] = 0;
        }
        // 화살이 남아버려서 0점에 쏘는 경우
        if(n!=0) answer[10]+=n;
        System.out.println(Arrays.toString(answer));
        System.out.println(Arrays.toString(info));
        // 점수 차이를 계산하여 지는 경우
        if(getScore(answer)<getScore(info)) answer = new int[]{-1};

        return answer;
    }

    public int getScore(int[] scores){
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i]*(MAX_SCORE-i);
        };
        return sum;
    }

    public int getBiggestIndex(double[] values){
        int idx = -1;
        double maxValue = 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i]>maxValue) {
                maxValue = values[i];
                idx=i;
            }
        }
        return idx;
    }

    // 이 곳에서 화살 하나당의 값어치를 계산하여 리턴
    public double[] getValues(int[] info){
        double[] values = new double[info.length];
        for (int i = 0; i < info.length; i++) {
            double score = (double)(MAX_SCORE-i)/(info[i]+1);
            if(info[i]==0) values[i] = score;
            else{
                values[i] = score*2;
            }
        }
        return values;
    }
}
