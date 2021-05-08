// DFS - 이진 트리 순회
class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}
public class DFS05TreeTraversal {
    Node root;

    public static void main(String[] args) {
        DFS05TreeTraversal tree = new DFS05TreeTraversal();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }

    private void DFS(Node root) {
        if(root == null) return;

//        System.out.print(root.data + " "); // 전위
        DFS(root.lt);
//        System.out.print(root.data + " "); // 중위
        DFS(root.rt);
        System.out.print(root.data + " "); // 후위

    }
}
