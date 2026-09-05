class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int start, int count){
        
        if(count == numbers.length){
            if(target == start)
                answer++;
            return;
        }
        
        
        dfs(numbers, target, start + numbers[count], count+1);
        dfs(numbers, target, start - numbers[count], count+1);
    }
}