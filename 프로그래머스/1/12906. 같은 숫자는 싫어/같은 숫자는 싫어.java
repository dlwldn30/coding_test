import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int a : arr){
            if(!dq.isEmpty() && dq.peekLast() == a){
                continue;
            }
            dq.offerLast(a);
        }
        
        return dq.stream().mapToInt(i->i).toArray();
    }
}