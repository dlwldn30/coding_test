import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length; i++)
            dq.offer(0);
        
        int time = 0; // 총 시간
        int total = 0; // 총 무게
        int tr = 0; // 트럭
        
        //현재 트럭이 개수보다 적을 동안
        while(tr < truck_weights.length){
            
            total -= dq.poll();
            
            if(total + truck_weights[tr] <= weight){
                dq.offer(truck_weights[tr]);
                total += truck_weights[tr];
                tr++;   
            }else{
                dq.offer(0);
            }
            
            time++;
        }
        
        return time+bridge_length;
    }
}