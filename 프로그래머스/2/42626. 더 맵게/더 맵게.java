import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        Arrays.sort(scoville);
        
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) pq.offer(scoville[i]);
        
        while(pq.peek() < K){
            
            if(pq.size() == 1){
                return -1;
            }
            
            
            int n1 = pq.poll();
            int n2 = pq.poll();
            
            int sum = n1 + 2*n2;
            pq.offer(sum);
            answer++;
        }
        
        
        return answer;
    }
}