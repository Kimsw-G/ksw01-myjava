package coding;



public class Colla {
    public static void main(String[] args) {
        CollaSolution sol = new CollaSolution();
        int a = 2;
        int b = 1;
        int n = 20;
        System.out.println(sol.solution(a, b, n));

    }

}

class CollaSolution {
    private int extra = 0;
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(true){
            int exchanged = exchange(a,b,n);
            if(exchanged==0)break;
            System.out.println(exchanged);
            answer += exchanged;
            n = exchanged;
        }
        return answer;
    }
    
    // 교환하기
    public int exchange(int a, int b, int n){
        int exchanged = n/a*b;
        if(exchanged ==0){
            n+=extra;
            extra=0;
            exchanged = n/a*b;
        }
        extra+=n%a;
        return exchanged;
    }
}