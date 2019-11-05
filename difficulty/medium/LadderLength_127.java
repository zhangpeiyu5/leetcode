package difficulty.medium;
//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索

import java.util.*;

public class LadderLength_127 {
    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        LadderLength_127 test = new LadderLength_127();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
//        wordList.add("cog");
        System.out.println(test.ladderLength2(beginWord, endWord, wordList));
    }

    /**
     * 方法一：传统DFS（超时），
     * 乍一看，和433题最小基因变化很像，用同样的方式做出来超时，注意：最小基因变化一题固定了字符串长度和字符串字母。
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        dfs(beginWord, endWord, wordList, 1, visited);
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }

    public void dfs(String beginWord, String endWord, List<String> wordList, int index, boolean[] visited) {
        if (index == wordList.size() || beginWord.equals(endWord)) {
            if (beginWord.equals(endWord)) {
                min = Math.min(min, index);
            }
            return;
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (!visited[i] && diffOne(wordList.get(i), beginWord)) {
                visited[i] = true;
                dfs(wordList.get(i), endWord, wordList, index + 1, visited);
                visited[i] = false;
            }
        }
    }


    public boolean diffOne(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        if (count != 1) {
            return false;
        }

        return true;
    }


    /**
     * BFS
     * 1）为找出相邻节点：对给定的 wordList 做一个【预处理】，将单词中的某个字母用 * 代替，预处理帮我们构造了一个单词变换的通用状态。
     * 例如：Dog ----> D*g <---- Dig，Dog 和 Dig 都指向了一个通用状态 D*g，因此Dog和Dig为相邻节点，D*g对应的list中有：Dog、Dig。
     * 2）进行广度搜索：queue中首先放入beginWord,弹出时，将与beginWord相邻的节点全部放入queue中，并且标记已经访问过的节点，每一层都如此处理，直到弹出的字符串等于endWord。
     *
     * 效率低
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> dictMap = new HashMap<>();

        //预处理，得到通用状态map
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < beginWord.length(); j++) {
                String word = wordList.get(i);
                String key = word.substring(0, j) + "*" + word.substring(j + 1, word.length());
                if (dictMap.containsKey(key)) {
                    dictMap.get(key).add(word);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(word);
                    dictMap.put(key, list);
                }
            }
        }


        //BFS
        List<String> visited = new ArrayList<>();
        int index = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        index++;

        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();

            while (curLevelSize > 0) {
                String cur = queue.poll();

                for (int i = 0; i < cur.length(); i++) {
                    String key = cur.substring(0, i) + "*" + cur.substring(i + 1, cur.length());
                    for (String adjacent : dictMap.getOrDefault(key, new ArrayList<>())) {
                        if (adjacent.equals(endWord)) {
                            return ++index;
                        }
                        if (!visited.contains(adjacent)) {
                            queue.add(adjacent);
                            visited.add(adjacent);
                        }
                    }
                }
                curLevelSize--;
            }
            index++;
        }
        return 0;
    }
}
