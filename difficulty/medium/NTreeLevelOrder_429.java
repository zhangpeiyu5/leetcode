package difficulty.medium;

import java.util.*;

/**
 * N 叉树的层序遍历
 */
public class NTreeLevelOrder_429 {
    public static void main(String[] args) {
        Node node1 = new Node(3, Arrays.asList(new Node(5, null), new Node(6, null)));
        Node node2 = new Node(2, null);
        Node node3 = new Node(4, null);
        Node root = new Node(1, Arrays.asList(node1, node2, node3));

        System.out.println(levelOrder(root).toString());
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);

                if (node.children != null && node.children.size() > 0) {
                    queue.addAll(node.children);
                }
            }
            res.add(list);
        }
        return res;
    }
}
