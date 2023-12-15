package G20200343030379;

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



public class LeetCode_25_379_2 {
    public static void main(String[] args) {
        char[][] ch={{'1','1'},{'1','1'},{'1','0'}};
//        char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    }


    /**
     * �����ݹ鷨
     * ȱ�㣺���Ӷ�̫����
     * ��⣺https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
     * ȱ�㣺ö�ٲ������ֵ�ʱ��ÿ�λ���ʱ��isValid()��һ���Ƿ�Ƿ���̫��ʱ�ˣ���ʵ����һ�Ѳ�ѯ�����ġ�
     *      *      ����˵1-9��Ҫ��10���Ƿ����㡣
     *                  ʵ����1-9 ֻҪ��һ�μ���֪���Ƿ�����ظ����⣨���Ż�����룺LeetCode_25_379_3����
     * ִ����ʱ : 29 ms , ������ Java �ύ�л����� 11.19% ���û�
     * �ڴ����� : 36.9 MB , ������ Java �ύ�л����� 18.99% ���û�
     * @param board
     */
    public void solveSudoku(char[][] board) {
        if(board.length==0) return;
        dfs(board,0,0);
    }

    public boolean dfs(char[][] board,int row ,int col) {
        int n = board.length;
        int m = board[0].length;
        for (int i = row; i < n; i++) {
            for (int j = col; j < m; j++) {
                if(board[i][j]!='.') continue;

                if(board[i][j]=='.'){
                    for(char c='1';c<='9'; c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;

                            //�M����һ��
                            if(dfs(board,row,col)){
                                return true;
                            }
                            //����ʧ�ܻ���
                            board[i][j]='.';
                            //�����˳������Ե�����һ������
                            //return false;
                        }
                    }
                    //10�����ֱ���������û��ƥ���ϣ������
                    return false;
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
