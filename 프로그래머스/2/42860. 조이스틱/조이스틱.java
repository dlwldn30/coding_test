class Solution {
    public int solution(String name) {
        int count = 0;
        int n = name.length();
        
        for (int i = 0; i < n; i++){
            char c = name.charAt(i);
            int min = Math.min(c - 'A', 'Z'-c+1);
            count += min;
        }
        
        int move = n-1;
        
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, i * 2 + (n - next));
            move = Math.min(move, (n - next) * 2 + i);
        }
        
        return count + move;
    }
}