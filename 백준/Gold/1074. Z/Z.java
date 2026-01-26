
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;
    static int width ;
    static int height;

    static void solve(int w, int h, int size) {

        if(size == 1) {
            System.out.println(result);
            return;
        }

        int newSize = size/2;

        if (width < w + newSize && height < h + newSize) {
            solve(w, h, newSize);                      // 1사분면
        } else if (width < w + newSize && height >= h + newSize) {
            result += newSize * newSize;
            solve(w, h + newSize, newSize);            // 2사분면
        } else if (width >= w + newSize && height < h + newSize) {
            result += 2 * newSize * newSize;
            solve(w + newSize, h, newSize);            // 3사분면
        } else {
            result += 3 * newSize * newSize;
            solve(w + newSize, h + newSize, newSize);  // 4사분면
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2,N);

        solve(0, 0, size);
    }
}
