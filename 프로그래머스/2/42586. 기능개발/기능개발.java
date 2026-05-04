import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> list = new ArrayList<>();
        int n = progresses.length;
        int[] day = new int[n];
        
        for(int i = 0; i < n; i++){
            day[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }
        
        int current = day[0];
        int count = 1;
        
        for(int i = 1; i < n; i++){
            if(day[i] <= current){
                count++;
            } else {
                list.add(count);
                current = day[i];
                count = 1;
            }
        }
        
        list.add(count);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}