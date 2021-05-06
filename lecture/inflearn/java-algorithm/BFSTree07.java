/*
7. 이진트리 레벨탐색(BFS : Breadth-First Search)
 */
import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    int data;
    Node2 lt, rt;
    public Node2(int val) {
        data = val;
        lt = rt = null;
    }
}

public class BFSTree07 {
    Node2 root;

    public static void main(String[] args) {
        BFSTree07 tree = new BFSTree07();
        tree.root = new Node2(1);
        tree.root.lt = new Node2(2);
        tree.root.rt = new Node2(3);
        tree.root.lt.lt = new Node2(4);
        tree.root.lt.rt = new Node2(5);
        tree.root.rt.lt = new Node2(6);
        tree.root.rt.rt = new Node2(7);
        tree.BFS(tree.root);
    }

    private void BFS(Node2 root) {
        Queue<Node2> queue = new LinkedList<>();
        queue.offer(root);

        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
//            System.out.print(L + " : " );
            for(int i = 0; i < len; i++) {
                Node2 node = queue.poll();
                System.out.print(node.data + " ");
                if(node.lt != null) queue.offer(node.lt);
                if(node.rt != null) queue.offer(node.rt);
            }
            L++;
            System.out.println();
        }
    }
}
