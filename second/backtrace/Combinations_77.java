package second.backtrace;

import java.util.ArrayList;
import java.util.List;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
public class Combinations_77 {
    public static void main(String[] args) {
        Combinations_77 test = new Combinations_77();
        int n = 4;
        int k = 2;
        System.out.println(test.combine(n, k));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, res, new ArrayList<>());
        return res;
    }

    public void dfs(int index, int n, int k, List<List<Integer>> res, List<Integer> list) {
        //terminator
        if (index > n || list.size() == k || n - index + 1 < k - list.size()) {
            if (list.size() == k) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        //每个元素有两种选择，要么不填加，要么添加list.add(index)
        dfs(index + 1, n, k, res, list);

        list.add(index);
        dfs(index + 1, n, k, res, list);

        //重置
        list.remove(list.size() - 1);
    }
}
