package G20200343030379;


import java.util.ArrayList;
import java.util.List;

/**
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
public class LeetCode_51_379_0 {
    public static void main(String[] args) {
       List<List<String>> strings = new LeetCode_51_379_0().solveNQueens(4);
        System.out.println(strings);
       new LeetCode_51_379_0().construct(new char[][]{{'1','2'}});


    }

    /**
     * ִ����ʱ : 17 ms , ������ Java �ύ�л����� 9.57% ���û�
     * �ڴ����� : 41.4 MB , ������ Java �ύ�л����� 5.86% ���û�
     *
     * ȱ�㣺1������ṹ��װ�Ƚϻ���
     *      2��ȥ���Ƿ�ѡ���㷨�������������Ż�
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        //N�ʺ�ṹ
        List<List<String>> nStrut=new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            List list = new ArrayList<>(n);
            for (int j = 1; j <= n; j++) {
                list.add(".");
            }
            nStrut.add(list);
        }

        //�洢���ܵ����н��
        List<List<String>> res=new ArrayList<>();
        boardtrack(res,nStrut,0);

        return res;
    }

    //�ֶ������

    /**
     *
     * @param res       ��ǰ��ʼ�����N�ʺ�ṹ��ÿ�����Ӷ��ǡ�.��
     * @param nStrut    �������ѡ������н��
     * @param row       ��
     */
    private void boardtrack(List<List<String>> res,List<List<String>> nStrut,
                            int row) {
        //1���˳���־
        if(row==nStrut.size()){
            res.add(construct(nStrut));
            return;
        }

        //2��ִ���߼�
        //2��������
        for (int i = 0; i < nStrut.size(); i++) {
            //2.1������Ƿ����ڹ�����Χ
            if(!isVaild(nStrut,row,i)){
                continue;
            }
            //2.2��������һ��
            List<String> strings = nStrut.get(row);
            strings.set(i,"Q");
            boardtrack(res,nStrut,row+1);
            //2.3�������β��������һ��
            strings.set(i,".");
        }
    }

    /**
     * У�鵱ǰλ���Ƿ���ã�����������Χ
     * true ����  false �ǿ��ã��ᱻ����
     * @param list ��ǰѡ��Ľ��
     * @param row  ��
     * @param col  ��
     * @return
     */
    private boolean isVaild(List<List<String>> list, int row, int col) {
        //��鵱ǰ���Ƿ���������Χ
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).get(col);
            if(s.equals("Q")){
                return false;
            }
        }

        //����������Ƿ���������Χ�����ų�����
        for(int i=row-1,j=col-1; i>=0 && j>=0;i--,j--){
            //��ȡi��j��
            String s = list.get(i).get(j);
            if(s.equals("Q")){
                return false;
            }
        }

        //������Ϸ��Ƿ���������Χ�����ų�����
        for(int i=row-1,j=col+1;i>=0 && j<list.size();i--,j++){
            //��ȡi��j��
            String s = list.get(i).get(j);
            if(s.equals("Q")){
                return false;
            }
        }
        return true;
    }

    //�ѵ�ǰѡ��Ľṹ����֯��һ��List<String> ����Ϊ��[{"..Q.","...Q"}]
    private List<String> construct(List<List<String>> board) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            StringBuilder sb=new StringBuilder();
            List<String> s = board.get(i);
            for (int j = 0; j < s.size(); j++) {
                sb.append(s.get(j));
            }
            list.add(sb.toString());
        }
        return list;
    }


    /****/
    private List<String> construct(char[][] board) {
        List<String > list=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }



}
