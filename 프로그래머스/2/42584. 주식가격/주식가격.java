class Solution {
    public int[] solution(int[] prices) {
        
        int[] arr = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                arr[i] ++;
                if(prices[i] > prices[j])
                    break;
            }
        }
        
        
        
        
        return arr;
    }
    
    
}