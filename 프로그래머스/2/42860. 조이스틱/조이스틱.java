class Solution {
    public int solution(String name) {
        
        int answer = 0;
        int l = name.length();
        
        for(int i = 0;  i < name.length(); i++){
            char c = name.charAt(i);
            
            int a = c - 'A';
            int b = 'Z'- c + 1;
            
            answer += Math.min(a, b);
        }
        
        int min = name.length()-1;
        
        for(int i = 0; i < name.length()-1; i++){
            int next = i + 1;
            
            while(next <= name.length()-1 && name.charAt(next) == 'A')
                next++;
            
            int n1 = i*2 + l-next;
            int n2 = (l-next) * 2 + i;
            
            min = Math.min(min, Math.min(n1, n2));
        }
        
        
        return answer + min;
    }
}