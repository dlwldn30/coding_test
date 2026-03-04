import java.util.*;

class Solution {
    
    boolean[] visited;
    String[] answer;
    boolean found;
    
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        visited = new boolean[tickets.length];
        answer = new String[tickets.length+1];
        
        //시작, 현재 문자열, 티켓, 종료조건용
        dfs("ICN", "ICN", tickets, 0);
        
        return answer;
    }
    
    private void dfs(String cur, String path, String[][] tickets, int count){
        
        if(found) return;
        
        if(count == tickets.length){
            answer = path.split(" ");
            found = true;
        }
        
        for(int i = 0; i < tickets.length; i++){
            
            if(!visited[i] && tickets[i][0].equals(cur)){
                
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count+1);
                visited[i] = false;
                
            }
        }
    }
}