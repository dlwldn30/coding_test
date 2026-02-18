import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] st1 = {1,2,3,4,5};
        int[] st2 = {2,1,2,3,2,4,2,5};
        int[] st3 = {3,3,1,1,2,2,4,4,5,5};
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for (int i = 0; i < answers.length; i++){
            if(answers[i] == st1[i%st1.length]) score1++;
            if(answers[i] == st2[i%st2.length]) score2++;
            if(answers[i] == st3[i%st3.length]) score3++;
        }
        
        int max = Math.max(score1, Math.max(score2, score3));
        
        List<Integer> list = new ArrayList<>();
        
        if(max == score1) list.add(1);
        if(max == score2) list.add(2);
        if(max == score3) list.add(3);
        
        return list.stream().mapToInt(i -> i).toArray();
        
        
    }
}