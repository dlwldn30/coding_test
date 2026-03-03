import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        Arrays.sort(mats);
        
        int n = park.length;
        int m = park[0].length;
        
        
        
        for (int i = mats.length-1; i >= 0; i--){ 
            
            int size = mats[i];
            
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    
                    if(!park[j][k].equals("-1"))
                        continue;
                    
                    if(j + size > n || k + size > m)
                        continue;
                    
                    boolean ok = true;
                    
                    for(int x = j; x < j+size; x++){
                        for(int y = k; y < k+size; y++){
                            if(!park[x][y].equals("-1")){
                                ok = false;
                                break;
                            }
                        }
                        if(!ok) break;
                    }
                    
                    if(ok) return size;
                    
                   
                }
            }
        }
        
        return -1;
    }
}