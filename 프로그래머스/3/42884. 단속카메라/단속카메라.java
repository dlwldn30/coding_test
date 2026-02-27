import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        
        int count = 1;
        
        int start = routes[0][1]; 
        
        for(int i = 1; i < routes.length; i++){
            if(start < routes[i][0]){
                start = routes[i][1];
                count++;
            }
        }
        
        return count;
        
        
    }
}