import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        List<Set<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++) list.add(new HashSet<>());
        
        for(int i = 1; i <= 8; i++){
            
            int repeat = 0;
            
            for(int j = 1; j <= i; j++)
                repeat = repeat*10+N;
            
            list.get(i).add(repeat);
            
            for(int j = 1; j < i; j++){
                for(int a : list.get(j)){
                    for(int b : list.get(i-j)){
                        list.get(i).add(a+b);
                        list.get(i).add(a-b);
                        list.get(i).add(a*b);
                        if(b!=0) list.get(i).add(a/b);
                    }
                }
            }
            
            if(list.get(i).contains(number)){
                return i;
            } 
        }
        
        return -1;
    }
}