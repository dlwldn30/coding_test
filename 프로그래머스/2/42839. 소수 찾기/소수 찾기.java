import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        boolean[] visited = new boolean[arr.length];
        
        int count = 0;
        
        dfs(arr, visited, "");
        
        for (int num : set){
            if(isPrime(num)) count++;
        }
        
        return count;
    }
    
    private void dfs(char[] arr, boolean[] visited, String current){
        if(!current.equals("")) 
            set.add(Integer.parseInt(current));
        
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(arr, visited, current + arr[i]);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num){
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
    
}