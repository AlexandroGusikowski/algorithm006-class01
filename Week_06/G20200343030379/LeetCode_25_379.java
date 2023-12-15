package G20200343030379;

import java.lang.annotation.ElementType;

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



public class LeetCode_25_379 {
    public static void main(String[] args) {
        char[][] ch={{'1','1'},{'1','1'},{'1','0'}};
//        char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    }


    /**
     * ȱ�㣺���Ӷ�̫����
     * ��⣺https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
     *
     * ִ����ʱ : 21 ms , ������ Java �ύ�л����� 16.69% ���û�
     * �ڴ����� : 36.7 MB , ������ Java �ύ�л����� 22.68% ���û�
     * @param board
     */
    public void solveSudoku(char[][] board) {
        if(board.length==0) return;
        dfs(board);
    }

    public boolean dfs(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]=='.'){
                    for(char c='1';c<='9'; c++){
                        if(isValid(board,i,j,c)){
                            if(c=='9') System.out.println("========");
                            board[i][j]=c;

                            //�M����һ��
                            if(dfs(board)){
                                return true;
                            }else{
                                //����ʧ�ܻ���
                                board[i][j]='.';
                                //�����˳������Ե�����һ������
                                //return false;
                            }
                        }else{
                            //�����˳������Ե�����һ������
                            //return false;
                        }
                    }
                    //10�����ֱ���������û��ƥ���ϣ������
                    return false;
                }else{
                    //dfs(board);
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board,int row, int col, char c) {
        int m = board[0].length;
        for (int index = 0; index < m; index++) {
            //�����ͬ��
            if(board[row][index]==c){

                return false;
            }

            //�����ͬ��
            if(board[index][col]==c){
                return false;
            }

            //ͬһ�����
            int xRow=(row / 3 * 3 + index / 3 );
            int yRow=(col / 3 * 3 + index % 3 );

            if(board[xRow][yRow]==c){
                return false;
            }
        }
        return true;
    }
}
