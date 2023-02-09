package coding;


public class FoodFighter {
    public static void main(String[] args) {
        FoodFighterSolution ffs = new FoodFighterSolution();
        int[] data = {1, 3, 4, 6};
        System.out.println(ffs.solution(data));
    }
}

class FoodFighterSolution {

    public String solution(int[] food) {
        String answer = "0";
        String preAnswer = "";
        String postAnswer = "";

        for(int i=1; i<food.length;i++){
            for (int j = 0; j < food[i]/2; j++) {
                postAnswer = i + postAnswer;
                preAnswer = preAnswer + i;
            }
        }
        
        return preAnswer + answer + postAnswer;
    }
}
