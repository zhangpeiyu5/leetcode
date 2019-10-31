package medium;

//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
//
// 注意:
//
//
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
// 所有的目标基因序列必须是合法的。
// 假定起始基因序列与目标基因序列是不一样的。
//
//
// 示例 1:
//
//
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
//
//
// 示例 2:
//
//
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
//
//
// 示例 3:
//
//
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
//
//
public class MinMutation_433 {
    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        MinMutation_433 test = new MinMutation_433();
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(test.minMutation1(start, end, bank));
    }

    /**
     * DFS
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation1(String start, String end, String[] bank) {
        dfs(start, end, bank, 0);
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    public void dfs(String start, String end, String[] bank, int index) {
        if (index == bank.length) {
            if (start.equals(end)) {
                min = Math.min(min, index);
            }
            return;
        }

        for (int i = 0; i < bank.length; i++) {
            if (start.equals(end)) {
                min = Math.min(min, index);
                return;
            } else if (diffOne(start, bank[i]) != 1) {
                continue;
            } else {
                dfs(bank[i], end, bank, index + 1);
            }
        }
    }

    public int diffOne(String a, String b) {
        int diffNums = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffNums++;
            }
        }
        return diffNums;
    }
}
