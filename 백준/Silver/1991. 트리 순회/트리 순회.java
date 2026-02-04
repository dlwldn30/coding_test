
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        char left;
        char right;

        Node(char left, char right){
            this.left = left;
            this.right = right;
        }
    }

    static StringBuilder sb = new StringBuilder();

    static void preOrder(int n){
        sb.append((char) (n+'A'));
        if(tree[n].left != '.')
            preOrder(tree[n].left-'A');
        if(tree[n].right != '.')
            preOrder(tree[n].right-'A');
    }

    static void inOrder(int n){
        if(tree[n].left != '.')
            inOrder(tree[n].left - 'A');
        sb.append((char) (n+'A'));
        if(tree[n].right != '.')
            inOrder(tree[n].right - 'A');
    }

    static void postOrder(int n){
        if(tree[n].left != '.')
            postOrder(tree[n].left - 'A');
        if(tree[n].right != '.')
            postOrder(tree[n].right - 'A');
        sb.append((char) (n+'A'));
    }

    static Node[] tree = new Node[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[parent - 'A'] = new Node(left, right);
        }

        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);

        System.out.println(sb);
    }
}
