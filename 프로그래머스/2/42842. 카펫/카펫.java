class Solution {
    
    
    
    public int[] solution(int brown, int yellow) {
        int[] sol = new int[2];
        
        int total = brown + yellow;
        
        for(int i = 1; i * i <= yellow; i++){
            if(yellow % i == 0){
                int n = yellow/i;
                if((i+2) * (n+2) == total){
                    sol[0] = Math.max(i+2, n+2);
                    sol[1] = Math.min(i+2, n+2);
                    break;
                }
            }
        }
        
        
        return sol;
    }
    
    
}