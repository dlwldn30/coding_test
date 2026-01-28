
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String s;
    static boolean[] visited;

    static void printS(int start, int end) {

        if(start > end) {
            return;
        }

        char min = s.charAt(start);
        int minIdx = start;


        //가장 작은 메서드 구하는 방법
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) < min) {
                min = s.charAt(i);
                minIdx = i;
            }
        }

        visited[minIdx] = true;

        for (int i = 0; i < s.length(); i++) {
            if(visited[i]){
                System.out.print(s.charAt(i));
            }

        }
        System.out.print("\n");
        printS(minIdx+1, end);
        printS(start,minIdx-1);


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        int e = s.length()-1;
        visited = new boolean[s.length()];

        printS(0, e);
    }
}
