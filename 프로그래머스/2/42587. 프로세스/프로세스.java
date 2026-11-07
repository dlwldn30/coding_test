import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> dq = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++){
            dq.offer(new int[]{i, priorities[i]});
        }
        
        int count = 1;
        
        while(!dq.isEmpty()){
            boolean hasHigher = false;
            int[] n = dq.pollFirst();
            
            for(int[] d : dq){
                if(n[1] < d[1]){
                    hasHigher = true;
                    break;
                }
            }
            
            if(hasHigher){
                dq.offerLast(n);
            }else{
                if(location == n[0])
                    return count;
                else{
                    count++;
                }
            }
        }
        
        
        return count;
    }
}