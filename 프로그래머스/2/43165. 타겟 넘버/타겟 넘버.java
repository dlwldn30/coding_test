class Solution {
    
    boolean[] visited;
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        
        visited = new boolean[numbers.length];
        
        
        dfs(numbers, target, 0, 0);
        
        return count;
    }
    
    private void dfs(int[] numbers, int target, int cur, int n){
        
        if(n == numbers.length){
            if(cur == target)
                count++;
            return;
        }
        
        dfs(numbers, target, cur+numbers[n], n+1);
        dfs(numbers, target, cur-numbers[n], n+1);
    }
}