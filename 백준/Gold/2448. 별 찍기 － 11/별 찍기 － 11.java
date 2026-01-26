
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] arr;


    //w = 가로, h = 세로
    static void solve(int h, int w, int size){

        if(size == 3){
            arr[h][w] = '*';
            arr[h+1][w-1] = '*';
            arr[h+1][w+1] = '*';
            for (int i = -2; i<=2; i++){
                arr[h+2][w-i] = '*';
            }
            return ;
        }

        int newSize = size/2;
        solve(h, w, newSize);
        solve(h+newSize, w-newSize, newSize);
        solve(h+newSize, w+newSize, newSize);




    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new char[N][2*N-1];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < 2*N-1; j++){
                arr[i][j] = ' ';
            }
        }

        // w = 가로, h = 세로
        solve(0,N-1, N);

        for (int i = 0; i < N; i++){
            for (int j = 0; j < 2*N-1; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
