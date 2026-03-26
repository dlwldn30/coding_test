import java.io.*;
import java.util.*;

public class Main {


    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int c = cur[2];

            if(x == n-1 && y == m-1)
                System.out.println(cur[2]);



            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, c+1});
            }
        }



    }


}