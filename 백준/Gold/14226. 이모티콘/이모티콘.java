
import java.io.*;
import java.util.*;


public class Main {

    static class Node{
        int corn;
        int clip;
        int dist;

        public Node(int corn, int clip, int dist) {
            this.corn = corn;
            this.clip = clip;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[1001][1001];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0, 0));
        visited[1][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.corn == n){
                System.out.println(cur.dist);
                return;
            }

            if(!visited[cur.corn][cur.corn]){
                visited[cur.corn][cur.corn] = true;
                q.add(new Node(cur.corn, cur.corn, cur.dist + 1));
            }
            if(cur.corn+cur.clip <= 1000 && !visited[cur.corn+cur.clip][cur.clip] ){
                visited[cur.corn+cur.clip][cur.clip] = true;
                q.add(new Node(cur.corn+cur.clip, cur.clip, cur.dist + 1));
            }
            if(cur.corn-1 >= 0 &&!visited[cur.corn-1][cur.clip]){ 
                visited[cur.corn-1][cur.clip] = true;
                q.add(new Node(cur.corn-1, cur.clip, cur.dist + 1));
            }

        }
    }
}