import java.util.*;

class Solution {
    
    boolean[] visited;
    boolean found;
    String[] result;
    
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        
        visited = new boolean[tickets.length];
        
        dfs(tickets, "ICN", "ICN", 0);
        
        return result;
    }
    
    private void dfs(String[][] tickets, String s, String answer, int count){
        
        if(found) return;
        
        if(count == tickets.length){
            found = true;
            result = answer.split(" ");
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(s)){
                visited[i] = true;
                dfs(tickets, tickets[i][1], answer + " " + tickets[i][1], count+1);
                visited[i] = false;
            }
        }
    }
}