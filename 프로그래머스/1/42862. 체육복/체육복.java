class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] stu = new int[n+2];
        
        for(int i = 1; i <= n; i++) stu[i] = 1;
        
        for(int l : lost) stu[l]--;
        for(int r : reserve) stu[r]++;
        
        for(int i = 1; i <= n; i++){
            if(stu[i] == 0){
                if(stu[i-1] >= 2){
                    stu[i-1]--;
                    stu[i]++;
                }else if(stu[i+1] >= 2){
                    stu[i+1]--;
                    stu[i]++;
                }
            }
        }
        
        int count = 0;
        
        for(int i = 1; i <= n; i++){
            if(stu[i] >= 1) count++;
        }
        
        
        return count;
    }
}