
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] tree;
    static String result;
    static StringBuilder sb = new StringBuilder();

    static void countPaper(int wide, int height, int length) {
        int n1 = length/2;

        int bCount = 0;
        int wCount = 0;

        // 1보다 작을 때 종료 조건
        if(length < 1)
            return;

        for (int i = wide; i < wide+length; i++) {
            for (int j = height; j < height+length; j++) {
                if (tree[i][j] == 1) {
                    bCount++;
                } else {
                    wCount++;
                }
            }
        }

        //색종이다 같을 경우
        if(bCount == length*length)
            sb.append("1");
        else if(wCount == length*length)
            sb.append("0");
        else{
            sb.append("(");
            countPaper(wide, height, n1);
            countPaper(wide, height + n1, n1);
            countPaper(wide+n1, height, n1);
            countPaper(wide+n1, height+n1, n1 );
            sb.append(")");
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        tree = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = N-1; j >= 0; j--) {
                tree[i][j] =  str.charAt(j) - '0';
            }
        }
        //시작점, 끝점
        countPaper(0, 0, N);

        System.out.println(sb);
    }
}
