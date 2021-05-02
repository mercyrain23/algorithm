// Tree 말단 노드까지의 까장 짧은 경로(BFS)

//class Node {
//    int data;
//    Node lt, rt;
//    public Node(int val) {
//        data = val;
//        lt = rt = null;
//    }
//}

import java.util.LinkedList;
import java.util.Queue;

public class Tree06BFS {
    Node root;

    public static void main(String[] args) {
        Tree06BFS tree = new Tree06BFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }

    private int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Node num = queue.poll();
                if(num.lt == null && num.rt == null) return L;
                if(num.lt != null) queue.offer(num.lt);
                if(num.rt != null) queue.offer(num.rt);
            }
            L++;
        }
        return 0;
    }
}
