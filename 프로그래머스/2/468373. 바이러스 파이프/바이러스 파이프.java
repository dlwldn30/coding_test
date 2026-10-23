import java.util.*;

class Solution {
    
    int answer = 1;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        // 파이프는 한번에 한 종류만 열고 닫을 수 있음
        // 가장 많은 감염체를 만들어야 함.
        // 감염 여부를 저장하는 배열이 필요함.
        // 그러면 결국 다 해보는거 밖에 없는거 같은데 이걸 어케 알거야
    
        boolean[] visited = new boolean[n+1];
        visited[infection] = true;
        
        dfs(edges, k, 0, visited);
        
        
        return answer;
    }
    
    private void dfs(int[][] edges, int k, int count, boolean[] visited){
        
        if(count == k){
            int max = 0;
            for(int i = 0; i < visited.length; i++){
                if(visited[i]) max++;
            }
            if(max > answer) answer = max;
            return;
        }
        
        for(int i = 1; i <= 3; i++){
            boolean[] vis = visited.clone();
            Queue<Integer> q = new LinkedList<>();
            
            for(int j = 1; j < vis.length; j++){
                if(vis[j]) q.offer(j);
            }
            
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int l = 0; l < edges.length; l++){
                    int a = edges[l][0];
                    int b = edges[l][1];
                    int c = edges[l][2];
                    
                    if(c == i){
                        if(cur == a && !vis[b]){
                            q.offer(b);
                            vis[b] = true;
                        }
                        if(cur == b && !vis[a]){
                            q.offer(a);
                            vis[a] = true;
                        }
                    }
                    
                }
            }
            dfs(edges, k, count+1, vis);
        }
    }
}