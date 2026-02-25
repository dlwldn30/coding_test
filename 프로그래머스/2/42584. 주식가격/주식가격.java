class Solution {
    public int[] solution(int[] prices) {
        
        int[] num = new int[prices.length];
        
        for(int i = 0; i < prices.length-1; i++){
            int n = prices[i];
            int day = 0;
            for (int j = i+1; j < prices.length; j++){
                day++;
                if(n > prices[j])
                    break;
                    
            }
            num[i] = day;
        }
        
        num[prices.length-1] = 0;
        
        return num;
    }
}