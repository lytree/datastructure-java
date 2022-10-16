package top.lytree.leetcode.day;

import java.util.ArrayList;
import java.util.List;

public class LC886 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        //每个人的颜色
        int[] color = new int[n + 1];
        //初始化 记录和i 不可以分同一组的
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; ++i) {
            g[i] = new ArrayList<>();
        }
        //记录不能在一组的
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; ++i) {
            //i未分组，把i分到a组，如果分到a组会冲突：false
            if (color[i] == 0 && !dfs(i, 1, color, g)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 深度优先搜索
     *
     * @param curNode  当前节点
     * @param curColor 节点分组 0表示未分组，1表示分组1，2表示分组2
     * @param color    每个节点分组情况
     * @param g        每个节点不能分同一组的
     *
     * @return
     */
    private boolean dfs(int curNode, int curColor, int[] color, List<Integer>[] g) {
        color[curNode] = curColor;
        for (int nextNode : g[curNode]) {

            if (color[nextNode] != 0 && color[nextNode] == color[curNode]) {
                return false;
            }
            if (color[nextNode] == 0 && !dfs(nextNode, 3 ^ curColor, color, g)) {
                return false;
            }

        }
        return true;
    }
}
