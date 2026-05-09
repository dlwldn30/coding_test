import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        int result = 1;
        
        int pos = routes[0][1];
        
        for(int i = 1; i < routes.length; i++){
            if(pos >= routes[i][0] && pos <= routes[i][1])
                continue;
            pos = routes[i][1];
            result++;
        }
        
        return result;
    }
}