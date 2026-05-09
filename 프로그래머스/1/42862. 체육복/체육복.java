class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        
        
        int[] clothes = new int[n+1];
        
        for (int i = 1; i <= n; i++)  clothes[i] = 1;
        
        for(int ls : lost) clothes[ls]--;
        for(int r : reserve) clothes[r]++;
        
        for (int i = 1; i <= n; i++){
            if(clothes[i] == 0){
                if(i > 1 && clothes[i-1] == 2){
                    clothes[i]++;
                    clothes[i-1]--;
                } 
                else if (i < n && clothes[i+1] == 2){
                    clothes[i]++;
                    clothes[i+1]--;
                }
            }
        }
        
        int count = 0;
        
        for (int i = 1; i <= n; i++){
            if(clothes[i] > 0) count++;
        }
        
        return count;
    }
}

