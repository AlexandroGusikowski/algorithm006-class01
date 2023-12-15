package G20200343030379;

import java.util.Arrays;

/**
 * 37. ������
 *
 * ��дһ������ͨ�������Ŀո�������������⡣
 *
 * һ�������Ľⷨ����ѭ���¹���
 *
 * ����?1-9?��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����?1-9?��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����?1-9?��ÿһ���Դ�ʵ�߷ָ���?3x3?����ֻ�ܳ���һ�Ρ�
 * �հ׸���?'.'?��ʾ��
 *
 *
 *
 * һ��������
 *
 *
 *
 * �𰸱���ɺ�ɫ��
 *
 * Note:
 *
 * ��������������ֻ��������?1-9?���ַ�?'.'?��
 * ����Լ������������ֻ��Ψһ�⡣
 * ����������Զ��?9x9?��ʽ�ġ�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sudoku-solver
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */



public class LeetCode_25_379_3 {
    public static void main(String[] args) {
        char[][] ch={{'1','1'},{'1','1'},{'1','0'}};
//        char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    }


    /**
     * ֱ�ӵݹ鷨 ���Ż�ʱ�临�ӶȰ棩
     * ��⣺https://leetcode.com/problems/sudoku-solver/discuss/15911/Less-than-30-line-clean-java-solution-using-DFS
     * �ŵ㣺ö�ٲ������ֵ�ʱ�������Ȱѳ��ֹ������ֲ�����ˣ�����ÿ�λ���ʱ���һ�Ρ�
     *      ����˵1-9��Ҫ��10���Ƿ����㣬����1-9 ֻҪ��һ�μ���֪���Ƿ�����ظ����⡣
     * ִ����ʱ : 9 ms , ������ Java �ύ�л����� 45.34% ���û�
     * �ڴ����� : 38.4 MB , ������ Java �ύ�л����� 7.90% ���û�
     * @param board
     */
    public void solveSudoku(char[][] board) {
        if(board.length==0) return;
        dfs(board,0);
    }

    public boolean dfs(char[][] board,int d) {
        int n = board.length;
        int m = board[0].length;
        //�ж��˳�
        if(d==n*m){
            return true;
        }

        int row = d / n;
        int col = d % n;

        if(board[row][col]!='.') {
            return dfs(board, d + 1);
        }else{
            boolean[] validB=new boolean[10];
            //�����ֵ�����
            //���Ĵ���
            isValid(board,row,col,validB);
            for (char c = '1'; c <= '9' ; c++){
                if(validB[c-'0']) {
                    //�ж��Ƿ���Ч
                    board[row][col] = c;
                    if(dfs(board,d + 1)){
                        return true;
                    }
                    //����״̬
                    board[row][col] = '.';
                }
            }

            //��ѯ���ж�û���򷵻�ʧ��
            return false;
        }


    }

    public boolean isValid(char[][] board,int row, int col, boolean[] validB) {
        Arrays.fill(validB,true);
        for (int index = 0; index < board.length; index++) {
            //������ͬ�У����ڵ�ֵ
            if(board[row][index]!='.') validB[board[row][index]-'0']=false;

            //������ͬ�У����ڵ�ֵ
            if(board[index][col]!='.') validB[board[index][col]-'0']=false;

            //��ͬͬһ���飬���ڵ�ֵ
            int xRow = row / 3 * 3 + index / 3;
            int xCol = col / 3 * 3 + index % 3;
            if(board[xRow][xCol]!='.') validB[board[xRow][xCol]-'0']=false;
        }
        return true;
    }
}
