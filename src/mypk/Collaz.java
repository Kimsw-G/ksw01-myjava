package mypk;

public class Collaz{
    public static void main(String[] args) {
        CollazSolution sol = new CollazSolution();
        System.out.println(sol.solution(6));
    }
}

class CollazSolution {
    public int solution(int num) {
        int answer = 0;
        long long_num = (long)num;
        while(true){
            if(answer==500){
                return -1;
            }else if(long_num==1){
                return answer;
            }else if(long_num%2==0) {
                long_num/=2;
                answer++;
            }else {
                long_num=long_num*3+1;
                answer++;
            }
        }
    }
}