package coding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

public class Solution04_solocard {
    
    public int solution(int[] cards) {
        int answer = 1;
        List<CardsInfo> infos = new ArrayList<>(); // 리스트가 그룹을 나타낸다
        infos.add(rotate(cards, 0)); // 첫번째 rotate를 돌린다
        int infosIdx=0; // infos 번호를 지칭 할 변수
        System.out.println(infos.get(0).toString());
        while (infos.get(0).nextSelect!=-1) { // 박스를 모두 꺼낸다
            CardsInfo cardsInfo = rotate(infos.get(infosIdx).cards, infos.get(infosIdx).nextSelect);
            infosIdx++;
            System.out.println(cardsInfo.toString());
            infos.add(cardsInfo);
            if(cardsInfo.nextSelect == -1) break;
        } 
        System.out.println("size: " + infos.size());
        if(infos.size()==1) return 0;
        for (CardsInfo info : infos) {
            answer*=info.cnt;    
        }

        return answer;
    }
    
    // 1) n번째 카드 고르기
    public CardsInfo rotate(int[] cards, int select){
        int next = select;
        int cnt = -1;
        System.out.println("do rotate");
        while(next != -1){
            next = cards[select]-1;
            cards[select] = 0;
            select = next;
            System.out.println("select : "+(select+1));
            cnt++;
        }
        
        return new CardsInfo(cards, cnt,searchNextSelect(cards));
    }
    public int searchNextSelect(int[] cards){ // 
        for (int i = 0; i < cards.length; i++) {
            if(cards[i]!=0) return i;
        }
        return -1;
    }
    class CardsInfo{
        Formatter formatter = new Formatter();
        int[] cards; // 현재 남은 카드 패
        int cnt; // 0이 아닌것의 개수
        int nextSelect; // 다음 탐색시 처음 탐색 할 숫자
        CardsInfo(int[] cards, int cnt,int nextSelect){
            this.cards = cards;
            this.cnt = cnt;
            this.nextSelect = nextSelect;
        }
        @Override
        public String toString(){
            return formatter.format("####\ncards : %s\ncnt : %s\nnextSelect : %s\n\n",Arrays.toString(cards),cnt,nextSelect).toString();
        }
    }
}
