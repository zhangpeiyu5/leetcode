package difficulty.hard;

import difficulty.medium.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
//
// 示例:
//
// 输入:
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"]
//
// 说明:
//你可以假设所有输入都由小写字母 a-z 组成。
//
// 提示:
//
//
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
//
public class FindWords2_212 {
    private Trie trie;
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        FindWords2_212 test = new FindWords2_212();
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = new char[][]{{'o', 'a', 'a', 'n' }, {'e', 't', 'a', 'e' }, {'i', 'h', 'k', 'r' }, {'i', 'f', 'l', 'v' }};
        System.out.println(test.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        //1.构造字典树
        constructTrie(words);

        //2.回溯二维网格，查找所有同时在二维网格和字典中出现的单词。
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, i, j, "", visited);
            }
        }

        return new ArrayList<>(set);
    }


    public void dfs(char[][] board, int x, int y, String str, boolean[][] visited) {
        //terminator
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return;
        }

        //process current level
        str += board[x][y];
        visited[x][y] = true;
        if (!trie.startsWith(str)) {   //匹配到前缀字符串
            visited[x][y] = false;  //回退
            return;
        }

        if (trie.search(str)) {   //完全匹配字符串
            set.add(str);
        }

        //drill down
        for (int i = 0; i < dx.length; i++) {
            dfs(board, x + dx[i], y + dy[i], str, visited);
        }

        //回退
        visited[x][y] = false;

    }

    public void constructTrie(String[] words) {
        trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
    }
}
