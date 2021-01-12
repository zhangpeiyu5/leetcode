package difficulty.medium;

public class MinMutation_433_2 {
    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        MinMutation_433_2 test = new MinMutation_433_2();
        System.out.println(test.minMutation(start, end, bank));
    }

    public int minMutation(String start, String end, String[] bank) {
        boolean[] visited = new boolean[bank.length];
        dfs(start, end, bank, visited, 0);
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    private void dfs(String start, String end, String[] bank, boolean[] visited, int count) {
        //终止条件
        if (count == bank.length) {
            if (start.equals(end)) {
                min = Math.min(min, count);
            }
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            //处理本层逻辑
            if (start.equals(end)) {
                min = Math.min(min, count);
                return;
            } else if (!visited[i] && diffOne(start, bank[i]) == 1) {
                visited[i] = true;  //标记元素已使用

                //下探到下一层
                dfs(bank[i], end, bank, visited, count + 1);

                //清理本层数据
                visited[i] = false; //重置元素为未使用
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
