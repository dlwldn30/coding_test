
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int max = -1;

    static boolean isPerfectSquare(int n) {
        if (n < 0) return false;
        int root = (int) Math.sqrt(n);
        return root * root == n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = M-1; j >= 0; j--) {
                map[i][j] = num%10;
                num /= 10;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for(int k = -N; k < N; k++){
                    for (int l = -M; l < M; l++){
                        if(k == 0 && l == 0) continue;

                        int sum = 0;

                        int newI = i;
                        int newJ = j;
                        while(newI >=0 && newI < N && newJ >=0 && newJ < M){
                            sum = sum*10+ map[newI][newJ];

                            if(isPerfectSquare(sum)){
                                max = Math.max(max, sum);
                            }

                            newI = newI + k;
                            newJ = newJ + l;
                        }

                    }
                }
            }
        }
        System.out.println(max);


    }
}
