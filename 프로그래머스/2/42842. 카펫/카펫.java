class Solution {
    
    
    
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        int[] sol = new int[2];
        
        for(int i = 1; i *i <= yellow; i++){
            if(yellow%i == 0){
                if((i+2) * (yellow/i+2) == total){
                    return new int[]{yellow/i+2, i+2};
                }
            }
        }
        
        return sol;
    }
    
    
}