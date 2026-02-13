
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][]matrix = new int[N][2];

        int max = C+100;
        int[] counts = new int[max+1];
        counts[0] = 0;

        for (int i = 1; i <= max; i++) {
            counts[i] = 10000000;
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = matrix[i][1]; j <= max; j++){
                counts[j] = Math.min(counts[j],  counts[j-matrix[i][1]] + matrix[i][0]);

            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = C; i<= max; i++){
            answer = Math.min(answer, counts[i]);
        }

        System.out.println(answer);


    }
}
