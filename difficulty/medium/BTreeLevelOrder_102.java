package difficulty.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索
public class BTreeLevelOrder_102 {
    public static void main(String[] args) {
        BTreeLevelOrder_102 test = new BTreeLevelOrder_102();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(test.levelOrder2(root));
    }

    /**
     * 广度优先遍历（BFS）
     *
     * 借助队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            while (levelSize > 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                levelSize--;
            }
            res.add(list);
        }
        return res;
    }


    /**
     * 方法二：深度优先遍历(DFS)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, root, res);
        return res;
    }

    public void dfs(int level, TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        List<Integer> curLevelList;
        if (res.size() <= level) {
            curLevelList = new ArrayList<>();
            res.add(curLevelList);
        } else {
            curLevelList = res.get(level);
        }

        curLevelList.add(root.val);
        res.set(level, curLevelList);

        dfs(level + 1, root.left, res);
        dfs(level + 1, root.right, res);
    }


}
