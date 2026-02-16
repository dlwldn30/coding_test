import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> list = new ArrayList<>();
        int length = progresses.length;
        int[] day = new int[length];
        
        for (int i = 0; i < length; i++){
            int progress = progresses[i];
            int speed = speeds[i];
            for (int j = 1; j <= 100; j++){
                if(progress + speed * j >= 100){
                    break;
                }
                day[i] = j;
            }
            
            
        }
        
        int num = day[0];
        int count = 1;
        
        for (int i = 1; i < length; i++){
            if(num < day[i]){
                list.add(count);
                num = day[i];
                count = 0;
            }
            count++;
            if(i == length-1){
                list.add(count);
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
        
        
        
        
    }
}