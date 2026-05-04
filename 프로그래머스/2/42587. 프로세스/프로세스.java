import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> dq = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++){
            dq.offer(new int[]{i, priorities[i]});
        }
        
        int count = 0;
        
        while(!dq.isEmpty()){
            int[] d = dq.poll();
            
            boolean hasHigher = false;
            
            for(int[] n : dq){
                if(d[1] < n[1]){
                    hasHigher = true;
                    break;
                }
            }
            
            if(hasHigher){
                dq.offer(d);
            }else{
                count++;
                if(d[0] == location) return count;
            }
            
            
            
        }
        return 0;
    }

}