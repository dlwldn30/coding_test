import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        int depth = 0;
        
        boolean[] visited = new boolean[words.length];
        
        Queue<String> q = new ArrayDeque<>();
        Queue<Integer> dep = new ArrayDeque<>();
        
        q.offer(begin);
        dep.offer(0);
        
        while(!q.isEmpty()){
            String cur = q.poll();
            int d = dep.poll();
            
            if(cur.equals(target)) return d;
            
            for (int i = 0; i < words.length; i++){
                
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