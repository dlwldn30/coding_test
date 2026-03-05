import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        
        Queue<String> q = new LinkedList<>();
        
        // 이걸 생각해내는 것이 중요!!!!
        Queue<Integer> dep = new LinkedList<>();
        
        q.offer(begin);
        dep.offer(0);
        
        while(!q.isEmpty()){
            
            String cur = q.poll();
            int d = dep.poll();
            
            if(cur.equals(target)) return d;
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && diffOne(words[i], cur)){
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
            char a1 = a.charAt(i);
            char b1 = b.charAt(i);
            
            if(a1 != b1) count++;
        }
        
        return count == 1;
    }
}