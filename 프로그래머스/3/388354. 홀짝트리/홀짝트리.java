import java.util.*;

class Solution {
    int a, b;
    List<Integer>[] graph = new ArrayList[1_000_001];
    int[] answer = new int[2];
    boolean[] visited = new boolean[1_000_001];
    
    public int[] solution(int[] nodes, int[][] edges) {
        
        // 1. 일단 노드들끼리 이어보자
        
        
        for(int node : nodes){
            graph[node] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        // 2. 하나씩 순찰을 돌아서 확인해야하나??
        // 3. 자식수를 모두 저장해놓을까? -> 근데 이건 아님 아 아닌가 
        for(int i = 0; i < nodes.length; i++){
            int num = nodes[i];
            if(!visited[num]){
                a = 0;
                b = 0;
                visited[num] = true;
                dfs(num);
                if(a == 1) answer[0]++;
                if(b == 1) answer[1]++;
                
            }
            
            
        }
        
        
        return answer;
    }
    
    private void dfs(int num){
        
        if(num % 2 == graph[num].size()%2){
            a++;
        }else{
            b++;
        }
        
        for(int n : graph[num]){
            if(!visited[n]){
                visited[n] = true;
                dfs(n);
            }
        }
    }
    
    
}