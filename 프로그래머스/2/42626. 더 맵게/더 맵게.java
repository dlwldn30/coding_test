import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int sc : scoville){
            pq.add(sc);
        }
        
        int count = 0;
        
        while(!pq.isEmpty() && pq.peek() < K){
            
            if(pq.size() == 1)
                return -1;
            int a = pq.poll();
            int b = pq.poll();
            int c = a + 2*b;
            pq.add(c);
            count++;
        }
        
        
        return count;
        
        
        
        
        
        
        
        
    }
}