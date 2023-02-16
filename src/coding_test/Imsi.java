package coding_test;

import java.util.*;
import java.util.Map.Entry;

public class Imsi {
    public static void main(String[] args) {
        int[][] info = { { -1, -2 }, { -2, -1 }, { 1, 2 }, { 2, 1 } };
        ImsiSolution s = new ImsiSolution();

        // System.out.println(Arrays.toString(s.solution(info)));
        System.out.println(s.solution(info));

    }
}

class ImsiSolution {
    public int solution(int[][] dots) {
        int answer = 0;
        double[] lengths = new double[6];
        int cnt = 0;
        for (int i = 0; i < dots.length-1; i++) {
            for (int j = i+1; j < dots.length; j++) {
                lengths[cnt++] = calcLength(dots[i], dots[j]);
            }
        }
        Arrays.sort(lengths);
        System.out.println(Arrays.toString(lengths));
        answer = (int)(lengths[0] * lengths[2]);

        return answer;
    }

    public double calcLength(int[] dot1, int[] dot2) {
        int x = (dot1[0] - dot2[0]);
        int y = (dot1[1] - dot2[1]);
        x = x*x;
        y = y*y;
        return Math.sqrt(x+y);
    }

}