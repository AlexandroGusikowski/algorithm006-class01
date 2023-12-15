package G20200343030379;

import java.util.ArrayList;
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
public class LeetCode_51_379_4 {


    public static void main(String[] args) throws InterruptedException {
        String s = "000010001".replaceAll("[\\s|0]", ".");
        String.format("%"+String.valueOf(2)+"s","2312");

        long start=System.currentTimeMillis();
        new LeetCode_51_379_4().solveNQueens(1);

        /*for (int i = 0; i < 1000*1000; i++) {
            Integer.toBinaryString(100);
        }*/
        System.out.println(new LeetCode_51_379_4().log2(8));

        long end =System.currentTimeMillis();


        System.out.println(end-start);
    }

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

        dfs(n,res,board,0,0,0,0);

        return res;
    }


    /**
     *
     * @param n  ����
     * @param board
     * @param r  row
     * @param c  col
     * @param lr lright
     * @param ll llfet
     */
    private void dfs(int n,List<List<String>> res,char[][] board,
                     int r, int c, int lr, int ll) {

        if(r==n){
            res.add(constans(board));
            return;
        }

        int bit = (~(c | lr | ll)) & ((1<<n) - 1);
        while (bit !=0){
            //��ȡ���λ
            int q=bit & (-bit);
            /*
            ̫��ʱ�������������ȡ��������1�ǵڼ�λ
            String s = Integer.toBinaryString(q);
            int col=s.length()-s.indexOf('1');*/

            int col= (int) log2(q);
            // %ns,q�Ķ�����
            board[r][col] = 'Q';

            dfs(n,res,board,r+1 , c|q ,(lr | q)>>1,(ll | q)<<1);
            board[r][col] = '.';
            bit = bit & (bit-1); //Ҳ����д�� bit -= p;
        }

    }


    private List<String> constans(char[][] board) {
        List<String> res=new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            String sb=new String(board[row]);
            res.add(sb);


        }
        return res;
    }



    //���������  1000 ʮ����8 �������λ��2^3=8;
    //�ο�����
    public double log2(double N) {
        return Math.log(N)/Math.log(2);//Math.log�ĵ�Ϊe
    }

}