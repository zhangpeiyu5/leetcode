package difficulty.hard;

import difficulty.medium.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal_145 {
    public static void main(String[] args) {
        PostorderTraversal_145 test = new PostorderTraversal_145();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = test.postorderTraversal2(root);
        System.out.println(list);
    }


    /**
     * 方法一：递归法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);
    }

    /**
     * 方法二：迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode temp = stack.peek();
                if (temp.right != null && temp.right != last) {     //last记录上次遍历的节点
                    root = temp.right;
                } else {
                    list.add(temp.val);
                    last = temp;
                    stack.pop();
                }
            }
        }

        return list;
    }


}
