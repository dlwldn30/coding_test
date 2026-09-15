import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        int idx = 0;
        
        while(idx < numbers.length){
             while(!dq.isEmpty() && numbers[dq.peek()] < numbers[idx]){
                 answer[dq.pop()] = numbers[idx];
             }
            dq.push(idx);
            idx++;
        }
        
        for(int i = 0 ; i < answer.length; i++){
            if(answer[i] == 0)
                answer[i] = -1;
        }
        
        
        
        return answer;
        
        
    }
}