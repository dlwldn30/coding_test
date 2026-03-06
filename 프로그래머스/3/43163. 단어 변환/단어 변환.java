import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        
        int length = words.length;
        
        visited = new boolean[length];
        
        Queue<String> q = new LinkedList<>();
        Queue<Integer> dep = new LinkedList<>();
        
        
        dep.offer(0);
        q.offer(begin);
        
        while(!q.isEmpty()){
            String cur = q.poll();
            int d = dep.poll();
            
            if(cur.equals(target)) return d;
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && diffOne(cur, words[i])){
                    visited[i] = true;
                    q.offer(words[i]);
                    dep.offer(d+1);
                }
            }
        }
        
        
        return 0;
        
        
        
        
    }
    
    private boolean diffOne(String a, String b){
        
        int count = 0;
        
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }
        
        return count == 1;
    }
}