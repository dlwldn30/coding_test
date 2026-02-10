
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    static class Node{
        int value;
        int row, col;

        public Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> b.value - a.value
        );

        for (int i = 0; i < N; i++) {
            pq.offer(new Node(arr[N-1][i], N-1, i));
        }

        for (int i = 0; i < N-1; i++) {
            Node n = pq.poll();
            pq.offer(new Node(arr[n.row-1][n.col], n.row-1, n.col));

        }

        System.out.println(pq.poll().value);


    }


}
