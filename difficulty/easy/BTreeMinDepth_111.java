package difficulty.easy;
//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索

import difficulty.medium.TreeNode;

public class BTreeMinDepth_111 {
    public static void main(String[] args) {
        BTreeMinDepth_111 test = new BTreeMinDepth_111();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(test.minDepth(root));
    }

    /**
     * 递归法
     * <p>
     * 时间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }
}
