import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long l = 1;
        long r = (long) times[times.length - 1] * n;
        
        long answer = r;
        
        while(l <= r){
            long mid = (l+r)/2;
            
            long count = 0;
            
            for(int i = 0; i < times.length; i++){
                count += mid / times[i];
                
                if(count >= n)
                    break;
            }
            
            if(count >= n){
                answer = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        
        
        return answer;
    }
}