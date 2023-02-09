package coding;
import java.util.Arrays;
import java.util.Collections;

public class Solution05_market {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i=0;i<discount.length-10;i++){
            String[] sepcDiscount = getSepcDiscount(discount, i);
            boolean flag = true;
            for(int j=0;j<want.length;j++){
                if(getCnt(sepcDiscount, want[j])!=number[j]){
                    flag = false;
                    j = want.length;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }

    public String[] getSepcDiscount(String[] discount, int i){// i부터 i+10까지 배열 추출
        return Arrays.copyOfRange(discount, i, i+10);
    }
    public int getCnt(String[] sepcDiscount, String product){// product가 몇개 들어있는지 확인
        return Collections.frequency(Arrays.asList(sepcDiscount), product);
    }
}
