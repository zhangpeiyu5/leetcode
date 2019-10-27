package difficulty.easy;

import difficulty.medium.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其层序遍历:
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//
//
//
// 说明:
//
//
// 树的深度不会超过 1000。
// 树的节点总数不会超过 5000。
// Related Topics 树 广度优先搜索
public class NTreeLevelOrder_429 {
    public static void main(String[] args) {
        NTreeLevelOrder_429 test = new NTreeLevelOrder_429();
        Node node1 = new Node(3, Arrays.asList(new Node(5, new ArrayList<>()), new Node(6, new ArrayList<>())));
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(4, new ArrayList<>());
        Node root = new Node(1, Arrays.asList(node1, node2, node3));
        System.out.println(test.levelOrder(root));
    }

    /**
     * 方法一：递归法
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(0, root, lists);
        return lists;
    }

    public void helper(int level, Node root, List<List<Integer>> lists) {
        if (root == null) {
            return;
        }

        List<Integer> curLevelList;
        if (lists.size() <= level) {
            curLevelList = new ArrayList<>();
            lists.add(curLevelList);
        } else {
            curLevelList = lists.get(level);
        }
        curLevelList.add(root.val);
        lists.set(level, curLevelList);

        List<Node> children = root.children;
        if (children != null && children.size() > 0) {
            for (int i = 0; i < children.size(); i++) {
                helper(level + 1, children.get(i), lists);
            }
        }
    }
}

