import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        Queue<Integer> list = new LinkedList<>();
        Deque<String> dq = new ArrayDeque<>();
        
        dq.offer(begin);
        list.add(0);
        
        while(!dq.isEmpty()){
            String s = dq.poll();
            int n = list.poll();
            
            if(s.equals(target)) return n;
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && diffOne(s, words[i])){
                    visited[i] = true;
                    dq.offer(words[i]);
                    list.offer(n+1);
                    
                }
            }
        }
        
        return 0;
    }
    
    private boolean diffOne(String s1, String s2){
        
        int count = 0;
        
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        
        return count == 1;
    }
}