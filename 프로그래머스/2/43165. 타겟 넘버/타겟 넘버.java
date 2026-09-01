class Solution {
    
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        
        int n = 0;
        
        dfs(numbers, target, 0, n);
        
        return count;
    }
    
    private void dfs(int[] numbers, int target, int num, int s){
        
        if(s == numbers.length){
            if(num == target)
                count++;
            return;
        }
        
        dfs(numbers, target, num - numbers[s], s+1);
        dfs(numbers, target, num + numbers[s], s+1);
    }
}