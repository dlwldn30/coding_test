import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        char[][] next = new char[r][c];

        int up = r; // 지도의 가장 위
        int down = 0; // 지도의 가장 아래
        int left = c; // 지도의 가장 왼쪽
        int right = 0; // 지도의 가장 아래쪽

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if(map[i][j] == 'X'){
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx < 0 || ny < 0 || nx >= r || ny >= c){
                            count++;
                        }else if (map[nx][ny] == '.'){
                            count++;
                        }
                    }

                    if(count < 3){
                        next[i][j] = 'X';
                        up = Math.min(up, i);
                        down = Math.max(down, i);
                        left = Math.min(left, j);
                        right = Math.max(right, j);
                    } else{
                        next[i][j] = '.';
                    }
                }
                else{
                    next[i][j] = '.';
                }
            }
        }

        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                sb.append(next[i][j]);
            }
            sb.append('\n');
        }


        System.out.println(sb);
    }
}
