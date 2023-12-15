package G20200343030379;





import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * 200. ��������
 *
 * ����һ����?'1'��½�أ��� '0'��ˮ����ɵĵĶ�ά���񣬼��㵺���������һ������ˮ��Χ����������ͨ��ˮƽ�����ֱ���������ڵ�½�����Ӷ��ɵġ�����Լ���������ĸ��߾���ˮ��Χ��
 *
 * ʾ�� 1:
 *
 * ����:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * ���:?1
 * ʾ��?2:
 *
 * ����:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * ���: 3
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-islands
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *  ������⣨��ȫ�����ֵ����Ż��㷨����
 *
 *  ����������
 */



public class LeetCode_200_379_1 {
    public static void main(String[] args) {
        /**
         * "hit"
         * "cog"
         * ["hot","dot","dog","lot","log","cog"]
         */
//        new LeetCode_200_379().findLadders("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog"));
    }

    /***
     * BSF �ݹ鷨
     * ִ����ʱ : 2 ms , ������ Java �ύ�л����� 93.24% ���û�
     * �ڴ����� : 42.2 MB , ������ Java �ύ�л����� 5.23% ���û�
     *
     * �ο���⣺https://leetcode.com/problems/number-of-islands/discuss/56359/Very-concise-Java-AC-solution
     * @param grid
     */
    public int numIslands(char[][] grid) {
        // '1'��½�أ��� '0'��ˮ��
        int count=0;
        //��
        int n=grid.length;
        if(n==0) return 0;
        int m=grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //½�ص�ʱ��ŵݹ�
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,n,m);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * �ݹ��������Ҫ��½�ر�Ϊˮ����ֹ�ظ�����
     * @param grid
     * @param i ��
     * @param j ��
     * @param n ����
     * @param m ����
     */
    private void dfs(char[][] grid, int i, int j, int n, int m) {
        //У��Ƿ�ֵ,�����ˮҲ��������
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0') return;

        //��½�ش���Ϊˮ����ֹ�ظ�����
        grid[i][j]='0';
        dfs(grid,i-1,j,n,m);
        dfs(grid,i+1,j,n,m);
        dfs(grid,i,j-1,n,m);
        dfs(grid,i,j+1,n,m);
    }





}
