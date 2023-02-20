
package coding_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snail {
    public static void main(String[] args) {
        SnailSolution s = new SnailSolution();
        System.out.println(Arrays.toString(s.solution(3)));
    }
    
}
class SnailSolution{
    public int n;
    public int[] solution(int n) {
        this.n = n;
        int[] answer = {};
        int[][] snail = new int[n][];
        int cnt = 1;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            snail[i] = new int[i+1];
        }
        while(n>0){
            cnt = snailRolling(snail, cnt, x, y);
            n-=3;
            x+=2;
            y+=1;
        }
        answer = snailToArray(snail);
        return answer;
    }
    
    public int snailRolling(int[][] snail, int cnt, int x, int y){
        for (int i = 0+x; i < n-y; i++) { // 1번째 순회. 0,0 ~ n-1,0
            snail[i][y] = cnt++;
        }
        for (int i = y+1; i < n-x; i++) { // 2번쨰 순회 n-1,0 ~ n-1,n-1
            snail[n-1-y][i] = cnt++;
        }
        for (int i = n-2-x; i > 0+y; i--) { // 3번째 순회. n-1,n-1 ~ n-2,n-2 ... 1,1
            snail[i+y][i] = cnt++;
        }
        testPrintArray(snail);

        // 이게 재귀로 돌아가야함
        return cnt;
    }

    public void testPrintArray(int[][] imsi){
        for (int i = 0; i < imsi.length; i++) {
            System.out.println(Arrays.toString(imsi[i]));
        }
    }

    public int[] snailToArray(int[][] snail){
        List<Integer> list = new ArrayList<Integer>();
        for (int[] arr : snail) {
            for (int i : arr) {
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}