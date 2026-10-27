import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int sum = 0;
        int cur = 0;
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i  = 0; i < k; i++){
            q.add(0);
        }
        
        for(int i = 0; i < players.length; i++){
            
            cur -= q.pollFirst();
            
            int a = players[i] / m;
            
            // 현재로 충분할 때
            if(cur - a >= 0){
                q.add(0);
            }else{
                int add = a - cur;
                
                sum += add;
                cur += add;
                q.offerLast(add);
            }
        }
        
        return sum;
    }
}