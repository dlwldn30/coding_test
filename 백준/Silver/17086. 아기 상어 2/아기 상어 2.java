
import java.io.*;
import java.util.*;


public class Main {

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    dist[i][j] = 0;
                } else{
                    dist[i][j] = -1;
                }
            }
        }

        int max = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if(dist[x][y] > max) max = dist[x][y];

            for(int k = 0; k < 8; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }

        }


        System.out.println(max);

    }
}