import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        
        List<String> group1 = make(str1);
        List<String> group2 = make(str2);
        
        int count = 0;
        
        for(String s1 : group1){
            if(group2.contains(s1)){
                count++;
                group2.remove(s1);
            }
        }
        
        int sum = group1.size() + group2.size();
        
        if(sum == 0) return 65536;
        
        double percet = (double) count / sum;
        
        return (int) (percet * 65536);
        
        
    }
    
    private List<String> make(String str){
        str = str.toLowerCase();
        
        List<String> group = new ArrayList<>();
        
        for(int i = 0; i < str.length()-1; i++){
            String sub = str.substring(i, i+2);
            
            char a = sub.charAt(0);
            char b = sub.charAt(1);
            
            if(Character.isLetter(a) && Character.isLetter(b))
                group.add(sub);
        }
        
        return group;
        
    }
}