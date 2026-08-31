import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i< bridge_length; i++){
            dq.offerLast(0);
        }
        
        int count = 0;
        int present = 0;
        int tr = 0;
        
        
        while(tr < truck_weights.length){
            
            present -= dq.poll();
            
            if(present + truck_weights[tr]<= weight){
                dq.offer(truck_weights[tr]);
                present += truck_weights[tr];
                tr++;
            }else{
                dq.offer(0);
            }
            
            count++;
        }
        
        return count += bridge_length;
    }
}