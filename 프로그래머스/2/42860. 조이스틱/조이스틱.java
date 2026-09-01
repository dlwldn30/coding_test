class Solution {
    public int solution(String name) {
        
        int n = name.length();
        int answer = 0;
        int max = 20;
        
        for(int i = 0; i < n; i++){
            char c = name.charAt(i);
            
            int a1 = c - 'A';
            int a2 = 'Z'- c + 1;
            
            answer += Math.min(a1, a2);
        }
        
        if(n == 1)
            return answer;
        
        for(int i = 0; i < n-1; i++){
            int next = i+1;
            
            while(next < n && name.charAt(next) == 'A'){
                next++;
            }
            
            int s1 = i*2 + n-next;
            int s2 = 2*(n-next) + i;
            
            int min = Math.min(s1, s2);
            max = Math.min(min, max);   
        }
        
        return answer + max;
    }
}