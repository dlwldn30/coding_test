class Solution {
    
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, 0, target);
        
        return count;
    }
    
    private void dfs(int[] numbers, int k, int number, int target){
        
        if(k == numbers.length){
            if(number == target) 
                count++;
            return;
        }
        
        
        int number1 = number + numbers[k];
        int number2 = number - numbers[k];
        
        k++;
        
        dfs(numbers, k, number1, target);
        dfs(numbers, k, number2, target);
        
            
    }
}