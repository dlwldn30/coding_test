import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        
        int count = 1;
        int idx = routes[0][1];
        
        int n = 1;
        
        for(int i = 1; i < routes.length; i++){
            if(routes[i][0] > idx){
                count++;
                idx = routes[i][1];
            }
        }
        
        
        return count;
    }
}