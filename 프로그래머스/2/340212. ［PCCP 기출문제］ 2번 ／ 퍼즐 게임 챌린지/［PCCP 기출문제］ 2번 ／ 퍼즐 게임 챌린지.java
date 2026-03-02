class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
    
        
        
        int left = 1;
        int right = 100000;
        int answer = right;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(canSolve(diffs, times, limit, mid)){
                answer = mid;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return answer;
            
    }
        
        
    

    private boolean canSolve(int[] diffs, int[] times, long limit, int level){
            long time = 0;
            long prev = 0;
        
            for(int i = 0; i < diffs.length; i++){
                long n = Math.max(diffs[i] - level, 0);
                time += (prev+times[i]) * n + times[i];
                
                if(time > limit) return false;
                
                prev = times[i];
            }
            return true;
    }
    
}