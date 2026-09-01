import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    int num = 0;
    
    public int solution(String numbers) {
        
        boolean[] visited = new boolean[numbers.length()];
        
        char[] arr = numbers.toCharArray();
        
        dfs(arr, visited, "");
        
        for(int a : set){
            if(isPrime(a)) num++;
        }
        
        return num;
    }
    
    
    private void dfs(char[] arr, boolean[] visited, String s){
        
        if(s.length() != 0){
            set.add(Integer.parseInt(s));
        }
        
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(arr, visited, s+arr[i]);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int a){
        
        if(a <= 1) return false;
        
        for(int i = 2; i * i <= a; i++){
            if(a%i == 0) return false;
        }
        
        
        return true;
    }
}