import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int n : arr){
            if(dq.isEmpty() || dq.peekLast() != n)
                dq.offerLast(n);
        }
        
        return dq.stream().mapToInt(i -> i).toArray();
    }
}