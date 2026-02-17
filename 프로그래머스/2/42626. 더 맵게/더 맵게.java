import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville){
            pq.offer(s);
        }
        
        int count = 0;
        
        while(!pq.isEmpty() && pq.peek() < K){
            if(pq.size() == 1){
                return -1;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            
            int mix = first + second*2;
            pq.offer(mix);
            count++;
        }
        
        return count;
    }
}