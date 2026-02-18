class Solution {
    
    
    
    public int[] solution(int brown, int yellow) {
        int[] sol = new int[2];
        int h = 0;
        int w = 0;
        
        for (int i = 1; i * i <= yellow; i++){
            h = yellow / i;
            w = i;
            if(yellow % i == 0){
                if(h * i == yellow && (h+2) * (i+2) == (brown + yellow))
                    break;
            }
        }
        
        sol[0] = h+2;
        sol[1] = w+2;
        
        return sol;
        
    }
    

}