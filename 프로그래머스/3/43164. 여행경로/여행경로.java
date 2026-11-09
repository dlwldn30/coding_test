import java.util.*;

class Solution {
    
    boolean[] visited;
    String[] answer;
    boolean found = false;
    
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        int n = tickets.length;
        
        visited = new boolean[n];
        
        dfs(tickets, "ICN", "ICN", 0, n);
        
        return answer;
    }
    
    private void dfs(String[][] tickets, String pre, String an, int count, int total){
        
        if(found) return;
        if(total == count){
            found = true;
            answer = an.split(" ");
            return;
        }
        
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(pre)){
                visited[i] = true;
                dfs(tickets, tickets[i][1], an + " " + tickets[i][1], count+1, total);
                visited[i] = false;
            }
        }
    }
}