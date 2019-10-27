package difficulty.medium;

import java.util.ArrayList;
import java.util.List;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索
public class IsValidBST_98 {
    public static void main(String[] args) {
        IsValidBST_98 test = new IsValidBST_98();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
        System.out.println(test.isValidBST2(root));
    }

    /**
     * 方法一： 递归法
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        if (lower != null && root.val <= lower) return false;
        if (upper != null && root.val >= upper) return false;

        if (!helper(root.left, lower, root.val)) return false;
        if (!helper(root.right, root.val, upper)) return false;

        return true;
    }


    /**
     * 看中序遍历后是否递增
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //中序遍历
        inOrder(root, list);
        if (list.size() < 2) {
            return true;
        }
        System.out.println(list);
        int j = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(j)) {
                return false;
            } else {
                j++;
            }
        }
        return true;
    }


    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
