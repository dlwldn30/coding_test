import java.util.*;

class Solution {
    
    class File{
        String head;
        int number;
        String original;
        
        File(String file){
            original = file;
            
            int i = 0;
            
            while(i < file.length() && !Character.isDigit(file.charAt(i)))
                i++;
            
            head = file.substring(0, i);
            
            int j = i;
            
            while(j < file.length() && Character.isDigit(file.charAt(j)) && j-i < 5)
                j++;
            
            number = Integer.parseInt(file.substring(i, j));
                
        }
    }
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        
        for(String f : files) list.add(new File(f));
        
        Collections.sort(list, (a, b) -> {
            
            int headCompare = a.head.toLowerCase().compareTo(b.head.toLowerCase());
            
            if(headCompare != 0) return headCompare;
            
            return a.number - b.number;
        });
        
        
        String[] answer = new String[files.length];
        
        for(int i = 0; i < files.length; i++) answer[i] = list.get(i).original;
        
        return answer;
            
            
        
    }
}