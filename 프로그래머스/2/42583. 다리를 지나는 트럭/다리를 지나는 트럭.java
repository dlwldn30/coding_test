import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        int total = 0;
        int answer = 0;
        int idx = 0;
        
        for(int i = 0; i < bridge_length; i++){
            dq.offer(0);
        }
        
        while(idx < truck_weights.length){
            
            int out = dq.poll();
            total -= out;
            
            if(truck_weights[idx] + total <= weight){
                dq.offer(truck_weights[idx]);
                total += truck_weights[idx];
                idx++;
            }else{
                dq.offer(0);
            }
            
            answer++;
        }
        
        return answer + bridge_length;
        
        
    }
}