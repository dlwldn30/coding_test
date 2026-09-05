import java.util.*;

class Solution {
    
    String[] answer;
    boolean[] visited;
    boolean found;
    
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        int n = tickets.length;
        visited = new boolean[n];
        
        dfs(tickets, "ICN", "ICN", 0, n);
        
        return answer;
    }
    
    private void dfs(String[][] tickets, String input, String result, int count, int total){
        
        
        if(found) return;
        
        if(count == total){
            found = true;
            answer = result.split(" ");
            return;
        }
        
        for(int i = 0; i < total; i++){
            if(!visited[i] && tickets[i][0].equals(input)){
                visited[i] = true;
                dfs(tickets, tickets[i][1], result + " " + tickets[i][1], count+1, total);
                visited[i] = false;
            }
        }
        
    }
}