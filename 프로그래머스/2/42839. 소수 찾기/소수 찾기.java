import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        char[] arr =numbers.toCharArray();
        boolean[] visited = new boolean[arr.length];
        
        dfs(arr, visited, "");
        
        
        int num = 0;
        for(int n : set){
            if(isPrime(n)) num++;
        }
        
        
        return num;
    }
    
    private void dfs(char[] arr, boolean[] visited, String s){
        if(!s.equals("")){
            set.add(Integer.parseInt(s));
        }
        
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(arr, visited, s + arr[i]);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n){
        
        if(n < 2) return false;
        
        for (int i = 2; i * i <= n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}