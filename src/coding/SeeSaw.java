package mypk;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SeeSaw {
    public static void main(String[] args) {
        int[] data = {100,180,360,100,270};
        // SeeSawSolution sss = new SeeSawSolution();
        // System.out.println(sss.solution(data));
        SeeSawFast ssf = new SeeSawFast();
        System.out.println(ssf.solution(data));
    }
}

class SeeSawSolution{ // too late
    public long solution(int[] weights) {
        long answer = 0;

        for(int i = 0; i<weights.length-1;i++){
            for (int j = i+1; j < weights.length; j++) {
                if (checkJak(weights[i], weights[j])) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public boolean checkJak(int weight1, int weight2){

        if(weight1<weight2){ //weight1이 무거운 사람임!
            int tmp = weight1;
            weight1 = weight2;
            weight2 = tmp;
        }
        if(weight1 == weight2) return true;
        // 2,3,4거리?
        // 먼저 weight1은 2에 앉히기
        // weight2는 3,4에 앉힘
        // 값이 없을시, weigth1을 3에, weigth2를 4에 앉힌 후, 종료
        for(int i=2;i<=4;i++){
            for(int j=i+1;j<=4;j++){
                if(weight1*i==weight2*j) return true;
            }
        }
        return false;
    }
}
class SeeSawFast{
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        
        answer = findJak(weights);
        
        return answer;
    }
    public long findJak(int[] list){
        long answer = 0;
        
        for (int i = 0; i < list.length; i++) {
            int end = getHigherIndex(list, list[i]*2);
            answer += findFreq(list, list[i], i+1,end);
            answer += findFreq(list, list[i]*2, i+1,end);
            if(list[i]%2==0)
                answer += findFreq(list, list[i]*3/2, i+1,end);
            if(list[i]%3==0)
                answer += findFreq(list, list[i]*4/3, i+1,end);
        }
        return answer;
    }
    public int getHigherIndex(int[] list, int value){
        int min = 0;
        int max = list.length-1;
        int mid;
        while(min <= max) {
            mid = (min + max) / 2;
    
            if(value == list[mid]) {
                return mid;
            } else if(value < list[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }
    public long findFreq(int[] list, int value ,int start, int end){ // k번째 배열부터 freq를 검사!
        long answer = 0;
        for(int i=start;i<end;i++){
            if(list[i] == value) answer++;
        }
        return answer;
    }
    
}