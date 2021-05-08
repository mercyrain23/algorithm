// Tree 말단노드까지의 까장 짧은 경로(DFS) -> BFS 로 하는걸 권장

//class Node {
//    int data;
//    Node lt, rt;
//    public Node(int val) {
//        data = val;
//        lt = rt = null;
//    }
//}

public class DFS09Tree {
     Node root;


    public static void main(String[] args) {
        DFS09Tree tree = new DFS09Tree();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.DFS(0, tree.root));
    }

    private int DFS(int L, Node root) {
        if(root.lt == null && root.rt == null) {
            return L;
        }

        return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
    }
}
