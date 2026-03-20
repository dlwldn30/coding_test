import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        List<Integer> list = new ArrayList<>();
        int result = 0;
        
        for(int i = 0; i < players.length; i++){
            
            int curServer = list.size();
            
            if(players[i] / m > curServer){
                for (int j = 0; j < players[i]/m - curServer; j++){
                    list.add(k);
                    result++;
                }
            }
            
            for(int j = list.size()-1; j >= 0; j--){
                list.set(j, list.get(j)-1);
                if(list.get(j) == 0)
                    list.remove(j);
            }
            
        }
        
        return result;
    }
}