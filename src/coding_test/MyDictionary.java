package coding_test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyDictionary {
    public static void main(String[] args) {
        MyDictionarySol s = new MyDictionarySol();
        // System.out.println(String.format("%05d", 1));
        System.out.println(s.solution("AAAAE"));
    }
    
}

class MyDictionarySol {
    char[] datas = { ' ','A', 'E', 'I', 'O', 'U' };
    final int MAX_LENGTH = 5;
    final int CASE = 55555;
    

    public int solution(String word) {
        int answer = 0;
        Set<String> diction = createDiction();
        // Iterator<String> itr =  diction.iterator();
        List<String> wordList = new ArrayList<String>(diction);
		answer = wordList.indexOf(word);

        return answer;
    }

    public Set<String> createDiction() {
        Set<String> diction = new TreeSet<String>();
        for (int i = 1; i <= CASE; i++) { 
            String word = "";
            String code = String.format("%05d", i);
            // System.out.println(code);
            for (int j = 0; j < code.length(); j++) {
                try {
                    word += datas[code.charAt(j)-48];
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            word = word.replaceAll(" ", "");
            // System.out.println();
            diction.add(word);
        }


        return diction;
    }
    

}
