package G20200343030379;



import java.util.ArrayList;
import java.util.List;

/**
 * �Ż���
 * 51. N�ʺ�
 *  n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 *  ��ͼΪ 8 �ʺ������һ�ֽⷨ��
 *
 * ����һ������ n���������в�ͬ��?n?�ʺ�����Ľ��������
 *
 * ÿһ�ֽⷨ����һ����ȷ��?n �ʺ���������ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��
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
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/n-queens
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺
 */
public class LeetCode_51_379_2 {
    public static void main(String[] args) {
       List<List<String>> strings = new LeetCode_51_379_3().solveNQueens(4);
        System.out.println(strings);
       new LeetCode_51_379_2().construct(new char[][]{{'1','2'}});


    }

    /**
     *  ִ����ʱ : 3 ms , ������ Java �ύ�л����� 90.88% ���û�
     *  �ڴ����� : 41.5 MB , ������ Java �ύ�л����� 5.58% ���û�
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j]='.';
            }
        }
        dfs(res,board,0);
        return res;
    }


    /**
     *
     * @param res       ��ǰ��ʼ�����N�ʺ�ṹ��ÿ�����Ӷ��ǡ�.��
     * @param nStrut    �������ѡ������н��
     * @param row       ��
     */
    private void dfs(List<List<String>> res,char[][] nStrut,int row) {
        //�˳�����
        if(nStrut.length==row){
            res.add(construct(nStrut));
            return ;
        }
        //ִ���߼�
        //����
        for (int col = 0; col < nStrut.length; col++) {
            //У��Ƿ�
            if(!validate(nStrut,row,col)){
                continue;
            }

            //ѡ��
            nStrut[row][col]='Q';
            //�ݹ�
            dfs(res,nStrut,row+1);
            //����ѡ��
            nStrut[row][col]='.';
        }
    }

    /**
     * У�鵱ǰλ���Ƿ���ã�����������Χ
     * true ����  false �ǿ��ã��ᱻ����
     * @param broad ��ǰѡ��Ľ��
     * @param row  ��
     * @param col  ��
     * @return
     */
    private boolean validate(char[][] broad, int row, int col) {
        //У�������еĵ�ǰ�У��Ƿ���ڻʺ�  i == col,���������ﴫ������col����Ϊ�ǻ���
        //broad.length ��ʵ���Ը�Ϊ row����Ϊ����Ŀ϶��ǿյ����ݣ������ܴ��ڹ�����Χ
        //for (int i = 0; i < broad.length; i++) {
        for (int i = 0; i < row; i++) {
            if(broad[i][col]=='Q'){
                return false;
            }
        }

        //У�����Ͻǣ��ų����� row-- ,col--
        for (int i = row-1,j = col-1; i>=0 && j>=0 ; i--,j--) {
            if(broad[i][j]=='Q'){
                return false;
            }
        }

        //У�����Ͻǣ��ų����� row-- , col++
        for (int i = row-1,j = col+1; i>=0 && j<broad.length ; i--,j++) {
            if(broad[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }


    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }



}
