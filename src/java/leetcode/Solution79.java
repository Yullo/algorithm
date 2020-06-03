package leetcode;

/**
 * Created by HAOYUXING on 2020/6/2.
 */
public class Solution79 {

    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     *  
     *
     * 示例:
     *
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     *  
     *
     * 提示：
     *
     * board 和 word 中只包含大写和小写英文字母。
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     * 1 <= word.length <= 10^3
     *
     * 链接：https://leetcode-cn.com/problems/word-search
     */

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 从每个位置开始尝试，只要找到一条，就返回true
                if (search(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, int idx, String word) {
        // 所有的字符都找到了，返回
        if (idx == word.length()) {
            return true;
        }

        char c = word.charAt(idx);
        // 没找到
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != c) {
            return false;
        }

        // 找到了，用占位符替换
        char temp = board[i][j];
        board[i][j] = '*';

        // 上下左右四个方向找下一个字符
        boolean res = search(board, i + 1, j, idx + 1, word);
        res = res || search(board, i - 1, j, idx + 1, word);
        res = res || search(board, i, j + 1, idx + 1, word);
        res = res || search(board, i, j - 1, idx + 1, word);

        //撤销选择
        board[i][j] = temp;

        return res;
    }

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        System.out.println(solution79.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCD"));
    }
}
