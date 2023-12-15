package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N�ʺ�
 * n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 *
 *
 *
 * ��ͼΪ 8 �ʺ������һ�ֽⷨ��
 *
 * ����һ������ n���������в�ͬ�� n �ʺ�����Ľ��������
 *
 * ÿһ�ֽⷨ����һ����ȷ�� n �ʺ���������ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��
 *
 * ʾ��:
 *
 * ����: 4
 * ���: [
 *  [".Q..",  // �ⷨ 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // �ⷨ 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * ����: 4 �ʺ��������������ͬ�Ľⷨ��
 *
 * �ο�������⣺
 * https://blog.csdn.net/u011433274/article/details/52487752
 * https://github.com/1yx/leetcode.org/blob/master/solutions/51.n%E7%9A%87%E5%90%8E.java
 */
public class LeetCode_51_379_5 {



    /**
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 41.1 MB , ������ Java �ύ�л����� 9.07% ���û�
     * @param n
     * @return
     */

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        if(n==0) return res;

        char board[][]=new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }

        dfs(n,board,res,0,0,0,0);

        return res;
    }

    private void dfs(int n,char[][] board, List<List<String>> res, int row, int col, int lr, int ll) {
        if(row==n){
            res.add(convers(board));
            return;
        }

        int bit= (~(col | lr | ll))  & ((1<<n )-1);
        while (bit!=0){
            int q = bit & (-bit);

            int colx = log2(q);
            board[row][colx]='Q';
            //�ݹ�
            dfs(n,board,res,row+1,col|q , (lr|q) >> 1,(ll|q) << 1);

            //����
            bit = bit & (bit -1);  //Ҳ����д�� bit -= p;
            board[row][colx]='.';
        }

    }

    private int log2(int q) {
        return (int) (Math.log(q)/Math.log(2));//Math.log�ĵ�Ϊe
    }

    private List<String> convers(char[][] board) {
        List<String> res=new ArrayList<>();

        /*
           �и���Ч�ı�������
        for (char[] chars : board) {
            StringBuilder sb=new StringBuilder();
            for (char aChar : chars) {
                sb.append(aChar);
            }
            res.add(sb.toString());
        }*/

        for (char[] chars : board) {
            String sb=new String(chars);
            res.add(sb);
        }
        return res;
    }


}