import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 이러면 같이 가는 게 많아야 함.
        // start에서 각 지점에 대해 최단 거리 구하기 
        // 공통 거리에 대해서 어떻게 할 거이냐
        // 이럴 거면 각 지점과 지점에 대해 최단 거리를 구하자
        
        int[][] dist = new int[n+1][n+1];
        int INF = 1_000_000_000;
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        for(int i = 0; i < fares.length; i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int w = fares[i][2];
            
            dist[from][to] = w;
            dist[to][from] = w;
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    int via = dist[i][k] + dist[k][j];
                    dist[i][j] = Math.min(dist[i][j], via);
                }
            }
        }
        
        int answer = INF;
        
        for(int i = 1; i <= n; i++){
            if(dist[s][i] == INF || dist[i][a] == INF || dist[i][b] == INF) continue;
            int cost = dist[s][i] + dist[i][a] + dist[i][b];
            answer = Math.min(answer, cost);
        }
        
        return answer;
    }
}