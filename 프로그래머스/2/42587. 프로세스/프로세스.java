import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> dq = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++){
            dq.offer(new int[]{priorities[i], i});
        }
        
        int count = 0;
        
        while(!dq.isEmpty()){
            int[] n = dq.poll();
            
            boolean higher = false;
            
            for(int[] q : dq){
                if(n[0] < q[0]){
                    higher = true;
                    break;
                } 
             }
            
            if(higher){
                dq.offer(n);
            } else{
                count++;
                if(n[1] == location)
                    return count;
            }
            
            
        }
        
        
        return 0;
    }

}