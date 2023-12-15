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
 */
public class LeetCode_51_379 {

    public static void main(String[] args) {
        //ʮ����ת������
        //String s = Integer.toBinaryString(-2147483648);
    }

    /**
     * ִ����ʱ : 3 ms , ������ Java �ύ�л����� 90.02% ���û�
     * �ڴ����� : 41.3 MB , ������ Java �ύ�л����� 8.20% ���û�
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
        dfs(board,res,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),0);
        return res;
    }

    private void dfs(char[][] board, List<List<String>> res
         , List<Integer> colList
            ,List<Integer> na
            ,List<Integer> pie, int row) {
        int n = board.length;
        //�˳�����
        if(row==n){
            res.add(constans(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if(na.contains(row+col)) continue;
            if(pie.contains(row-col)) continue;
            if(colList.contains(col)) continue;

            //ѡ��
            board[row][col]='Q';
            colList.add(col);
            na.add(row+col);
            pie.add(row-col);

            //�ݹ�
            dfs(board,res,colList,na,pie,row+1);

            //����
            board[row][col]='.';
            colList.remove(row);
            na.remove(row);
            pie.remove(row);
        }
    }

    private boolean validate(char[][] board,int row,int col) {
        //��鵱��
        for (int i = 0; i < row; i++) {
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //������Ͻ�
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //������Ͻ�
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    private List<String> constans(char[][] board) {
        List<String> res=new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            String sb=new String(board[row]);
            res.add(sb);
        }
        return res;
    }

    /*
    ʱ�临�Ӷȶ࣬������ʹ��
    private List<String> constans(char[][] board) {
        List<String> res=new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[row][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }*/
}