
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n+1][m+1];
        visited[0][s] = true;
        arr[0] = s;


        //n의 횟수
        for(int i = 1; i <= n; i++){
            //최대
            for(int j = 0; j <= m; j++){
                if(visited[i-1][j]){
                    if(j+arr[i] <= m) visited[i][j+arr[i]] = true;
                    if(j-arr[i] >= 0) visited[i][j-arr[i]] = true;
                }
            }
        }

        for(int i = m; i >= 0; i--){
            if(visited[n][i]) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}