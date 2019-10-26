package difficulty.easy;

import difficulty.medium.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其前序遍历: [1,3,5,6,2,4]。
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树
public class NTreePreorder_589 {
    public static void main(String[] args) {
        NTreePreorder_589 test = new NTreePreorder_589();
        Node node1 = new Node(3, Arrays.asList(new Node(5, new ArrayList<>()), new Node(6, new ArrayList<>())));
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(4, new ArrayList<>());
        Node root = new Node(1, Arrays.asList(node1, node2, node3));
        System.out.println(test.preorder2(root));
    }

    /**
     * 方法一：递归法
     *
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        List<Node> children = root.children;
        if (children != null && children.size() > 0) {
            for (Node child : children) {
                helper(child, list);
            }
        }

    }

    /**
     * 方法二：迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            list.add(cur.val);
            if (cur.children.size() != 0) {
                List<Node> children = cur.children;
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return list;
    }
}
