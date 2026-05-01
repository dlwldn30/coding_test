class Solution {
    public int[] solution(int[] prices) {
        
        int[] arr = new int[prices.length];
        
        for(int i = 0; i < prices.length-1; i++){
            int count = 0;
            
            for(int j = i+1; j < prices.length; j++){
                count++;
                if(prices[i] > prices[j])
                    break;
            }
            arr[i] = count;
        }
        
        arr[prices.length-1] = 0;
        
        
        
        return arr;
    }
    
    
}