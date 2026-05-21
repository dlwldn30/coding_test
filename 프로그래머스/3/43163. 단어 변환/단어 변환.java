import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        
        Queue<String> q = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        q.offer(begin);
       cq.offer(0);
        
        while(!q.isEmpty()){
            String s = q.poll();
            int count = cq.poll();
            
            if(s.equals(target)) return count;
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && diffOne(s, words[i])){
                    visited[i] = true;
                    q.offer(words[i]);
                    cq.offer(count + 1);
                }
            }
        }
        
        
        return 0;
        
    }
    
    
    private boolean diffOne(String s1, String s2){
        int l = s1.length();
        int count = 0;
        
        for(int i = 0; i < l; i++){
            if(s2.charAt(i) != s1.charAt(i)) count++;
        }
        
        return count == 1;
    }
}