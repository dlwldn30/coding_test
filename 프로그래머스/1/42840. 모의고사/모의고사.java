import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] st1 = {1,2,3,4,5};
        int[] st2 = {2,1,2,3,2,4,2,5};
        int[] st3 = {3,3,1,1,2,2,4,4,5,5};
        
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        
        for (int i = 0; i < answers.length; i++){
            if(answers[i] == st1[i%5]) s1++;
            if(answers[i] == st2[i%8]) s2++;
            if(answers[i] == st3[i%10]) s3++;
        }
        
        int max = Math.max(s1, Math.max(s2, s3));
        
        List<Integer> list = new ArrayList<>();
        
        if (max == s1) list.add(1);
        if (max == s2) list.add(2);
        if (max == s3) list.add(3);
        
        return list.stream().mapToInt(i->i).toArray();
        
    }
}