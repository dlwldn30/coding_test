class Solution {
    public int[] solution(int[] prices) {
        
        int length = prices.length;
        int[] sol = new int[length];
        
        for (int i = 0; i < length; i++){
            int count = 0;
            int price = prices[i];
            for (int j = i+1; j < length; j++){
                count++;
                if(price > prices[j]){
                    break;
                }
                
            } 
            sol[i] = count;
        }
        
        
        return sol;
    }
}