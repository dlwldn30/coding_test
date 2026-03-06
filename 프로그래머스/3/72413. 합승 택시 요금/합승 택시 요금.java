import java.util.*;

class Solution {

    List<List<int[]>> graph = new ArrayList<>();

    public int solution(int n, int s, int a, int b, int[][] fares) {

        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for(int[] f : fares){
            int u = f[0];
            int v = f[1];
            int w = f[2];

            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }

        int[] distS = dijkstra(n, s);
        int[] distA = dijkstra(n, a);
        int[] distB = dijkstra(n, b);

        int answer = Integer.MAX_VALUE;

        for(int i=1;i<=n;i++){
            answer = Math.min(answer,
                    distS[i] + distA[i] + distB[i]);
        }

        return answer;
    }

    private int[] dijkstra(int n, int start){

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((x,y)->x[1]-y[1]);

        pq.offer(new int[]{start,0});
        dist[start] = 0;

        while(!pq.isEmpty()){

            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            if(cost > dist[node]) continue;

            for(int[] next : graph.get(node)){

                int nextNode = next[0];
                int nextCost = cost + next[1];

                if(nextCost < dist[nextNode]){
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode,nextCost});
                }
            }
        }

        return dist;
    }
}