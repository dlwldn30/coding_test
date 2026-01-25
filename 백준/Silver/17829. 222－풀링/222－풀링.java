

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] paper;


    static void countPaper() {

        while(N > 1){
            for (int i = 0; i < N; i+=2) {
                for (int j = 0; j < N; j+=2) {
                    int [] tmp = {paper[i][j], paper[i+1][j], paper[i][j+1], paper[i+1][j+1]};
                    Arrays.sort(tmp);
                    paper[i/2][j/2] = tmp[2];
                }
            }
            N /= 2;
        }


    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //시작점, 끝점
        countPaper();

        System.out.println(paper[0][0]);


    }
}
