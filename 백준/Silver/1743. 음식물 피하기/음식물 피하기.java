
import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a-1][b-1] = 1;
        }

        int max = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(map[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    int count = 1;
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];

                        for(int d = 0; d < 4; d++){
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if(map[nx][ny] == 0) continue;
                            if(visited[nx][ny]) continue;

                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                            count++;
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }

        System.out.println(max);


    }


}