package G20200343030379;

import java.util.ArrayList;
import java.util.List;

/**
 * 52. N�ʺ� II
 * n?�ʺ������о�������ν� n?���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 *
 *
 *
 * ��ͼΪ 8 �ʺ������һ�ֽⷨ��
 *
 * ����һ������ n������ n �ʺ�ͬ�Ľ��������������
 *
 * ʾ��:
 *
 * ����: 4
 * ���: 2
 * ����: 4 �ʺ������������������ͬ�Ľⷨ��
 * [
 * ?[".Q..", ?// �ⷨ 1
 * ? "...Q",
 * ? "Q...",
 * ? "..Q."],
 *
 * ?["..Q.", ?// �ⷨ 2
 * ? "Q...",
 * ? "...Q",
 * ? ".Q.."]
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/n-queens-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺
 * https://blog.csdn.net/u011433274/article/details/52487752
 * https://github.com/1yx/leetcode.org/blob/master/solutions/51.n%E7%9A%87%E5%90%8E.java
 */
public class LeetCode_52_379 {

    public static void main(String[] args) {
        int count = Integer.highestOneBit(12);
        System.out.println(count);
        Integer.bitCount(12);
    }

    /**
     * ִ����ʱ : 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 36.2 MB , ������ Java �ύ�л����� 5.35% ���û�
     *
     * �ο�������⣺
     * https://blog.csdn.net/u011433274/article/details/52487752
     * https://github.com/1yx/leetcode.org/blob/master/solutions/51.n%E7%9A%87%E5%90%8E.java
     * @param n
     * @return
     */
    int count=0;
    public int totalNQueens(int n) {
        if(n==0) return 0;

        char[][] board=new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }

        dfs(n,board,0,0,0,0);
        return count;

    }

    private void dfs(int n, char[][] board, int row, int col, int ll, int lr) {
        if(n==row) {
            count++;
            return;
        }

        int bit=(~(col|ll|lr) & (1 << n)-1);

        while (bit!=0){
            int q=bit & (-bit); //��0���λ

            int colx=log2(q);
            board[row][colx]='Q';

            dfs(n,board,row+1,col|q , (ll|q)<<1 , (lr|q) >>1);

            bit =bit & (bit-1);
            board[row][colx]='.';

        }
    }

    private int log2(int q) {
        return (int) (Math.log(q)/Math.log(2));
    }



}