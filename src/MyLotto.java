import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * MyLotto
 */
public class MyLotto {
    static final int LOTTO_LENGTH = 45;
    static final int LOTTO_SHEET = 6;
    static final int LUCKY_NUM = 43;

    public static void main(String[] args) {
        printLotto(5);

    }

    public static void printLotto(int paper) {
        for (int i = 0; i < paper; i++) {
            Set<Integer> lottoBox = createLottoBox(LUCKY_NUM);
            
            Iterator<Integer> lottoItr = lottoBox.iterator();
            while (lottoItr.hasNext()) {
                System.out.printf("%d\t",lottoItr.next());
                if(lottoItr.hasNext())System.out.printf(" , ");
            }
            System.out.println();
        }
    }

    public static Set<Integer> createLottoBox(int luckyNum) {
        Set<Integer> lottoBox = new TreeSet<Integer>();
        lottoBox.add(luckyNum);
        while (lottoBox.size() != 6) {
            lottoBox.add((int) (Math.random() * 45 + 1));
        }
        return lottoBox;
    }

}