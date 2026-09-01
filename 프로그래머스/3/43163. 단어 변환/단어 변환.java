import java.util.*;

class Solution {
    
    boolean[] visited;
    int answer = 0;
    boolean found;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        
        
        
        dfs(begin, target, 0, words);
        
        return answer;
    }
    
    private void dfs(String begin, String target, int count, String[] words){
        
        if(found) return;
        
        if(target.equals(begin)){
            answer = count;
            found = true;
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(!visited[i] && diffOne(begin, words[i])){
                visited[i] = true;
                dfs(words[i], target, count+1, words);
                visited[i] = false;
            }
        }
        
        
    }
    
    private boolean diffOne(String s1, String s2){
        int n = s1.length();
        int c = 0;
        
        for(int i = 0; i < n; i++){
            if(s1.charAt(i) != s2.charAt(i)) c++;
        }
        
        return c == 1;
    }
}