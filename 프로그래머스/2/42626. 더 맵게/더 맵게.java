import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        
        for(int sc : scoville){
            pq.offer(sc);
        }
        
        while(!pq.isEmpty() && pq.peek() < K){
            if(pq.size() == 1)
                break;
            int first = pq.poll();
            int second = pq.poll();
            
            int food = first + second*2;
            count++;
            pq.offer(food);
        }
        
        if(pq.peek() < K)
            return -1;
        
            
        return count;
    }
}