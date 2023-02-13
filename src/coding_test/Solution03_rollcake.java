package coding_test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Solution03_rollcake {
    // 1) 총 몇종류인지 구하기
    // 2) cake를 n번째부터 len-n까지 잘라본다.
    // 3) 1번 배열과 2번 배열의 종류 가짓수를 비교, 값이 같은지 비교한다
    // 3-if-true) 값이 같다면 cnt++
    // 3-if-false0 값이 다르다면 cnt--
    public int solution(int[] topping) {
        int answer = 0;

        for(int i = 1;i<topping.length-1;i++){
            List<Set<Integer>> twoCake = getTwoCake(topping, i);
            if(twoCake.get(0).size() == twoCake.get(1).size()) answer++;
            System.out.println("answer : "+answer);
        }

        return answer;
    }

    // 1) 종류 구하기
    public int getLagest(int[] topping){
        int result=0;
        for (int i : topping) {
            if(result<i) result=i;
        }
        return result;
    }

    // 2) cake 잘라보기
    public List<Set<Integer>> getTwoCake(int[] topping, int knife){
        Set<Integer> firstCake = new HashSet<>();
        Set<Integer> secondCake = new HashSet<>();
        for(int i=0;i<knife;i++){
            firstCake.add(topping[i]);
        }
        for(int i=knife;i<topping.length;i++){
            secondCake.add(topping[i]);
        }
        List<Set<Integer>> twoCake = new ArrayList<Set<Integer>>();
        twoCake.add(firstCake);
        twoCake.add(secondCake);
        System.out.println("knife : " + knife);
        printSet(firstCake);
        printSet(secondCake);
        return twoCake;
    }

    public void printSet(Set<Integer> set){
        Iterator<Integer> iterSet = set.iterator();
        while(iterSet.hasNext()) {
            System.out.print(iterSet.next() +" ");
        }
        System.out.println("size : "+set.size());
    }
    
}
