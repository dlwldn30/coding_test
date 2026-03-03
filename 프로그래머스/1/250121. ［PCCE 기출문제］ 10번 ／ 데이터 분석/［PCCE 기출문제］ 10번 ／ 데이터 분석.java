import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<int[]> list = new ArrayList<>();
        
        int extIndex = 0;
        if(ext.equals("code")) extIndex = 0;
        else if(ext.equals("date")) extIndex = 1;
        else if(ext.equals("maximum")) extIndex = 2;
        else extIndex = 3;
        
        int extSort = 0;
        if(sort_by.equals("code")) extSort = 0;
        else if(sort_by.equals("date")) extSort = 1;
        else if(sort_by.equals("maximum")) extSort = 2;
        else extSort = 3;
        
        for(int[] row : data){
            if(row[extIndex] < val_ext)
                list.add(row);
        }
        
        final int sort = extSort;
        
        list.sort((a,b) -> a[sort] - b[sort]);
        
        int[][] answer = new int[list.size()][4];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}