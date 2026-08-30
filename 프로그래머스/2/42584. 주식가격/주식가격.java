import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        
        int t = 0;
        
        while(t < prices.length){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[t]){
                answer[stack.peek()] = t-stack.peek();
                stack.poll();
            }
            
            stack.push(t);
            t++;
        }
        
        while(!stack.isEmpty()){
            int q = stack.poll();
            answer[q] = prices.length-q-1;
        }
        
        
        return answer;
        
    
    }
}