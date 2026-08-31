class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int count = 0;
        
        int[] total = new int[n+2];
        
        for (int i = 1; i <= n; i++){
            total[i] = 1;
        }
        
        for (int i = 0; i < lost.length; i++){
            total[lost[i]]--;
        }
        
        for(int i = 0; i < reserve.length; i++){
            total[reserve[i]]++;
        }
        
        for (int i = 1; i <= n; i++){
            if(total[i] == 0){
                if(total[i-1] >= 2){
                    total[i]++;
                    total[i-1]--;
                }else if(total[i+1] >= 2){
                    total[i]++;
                    total[i+1]--;
                }
            }
        }
        
        
        for (int i = 1; i <= n; i++){
            if(total[i] >= 1){
                count++;
            }
        }
        
        return count;
    }
}

