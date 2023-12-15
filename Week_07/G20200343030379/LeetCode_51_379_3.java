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
public class LeetCode_51_379_3 {


    private int size;
    private int count;
    /**
     * ִ����ʱ : 51 ms , ������ Java �ύ�л����� 5.14% ���û�
     * �ڴ����� : 43.6 MB , ������ Java �ύ�л����� 5.18% ���û�
     * @param n
     * @return
     */
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        dfs(n,new ArrayList<>(),0,0,0,0);
        conver(res);
        return res;
    }

    private void conver(List<List<String>> res) {
        for (List<String> re : res) {
            for (int i = 0; i < re.size(); i++) {
                String q = String.format("%" + String.valueOf(re.size()) + "s"
                        //��� 0001001  ���0 �滻Ϊ"."
                        , re.get(i)).replaceAll("[\\s|0]", ".")
                        .replaceAll("1", "Q");
                re.set(i,q);
            }
        }
    }

    private void dfs(int n, List<String> board,
                     int r, int c, int lr, int ll) {
        if(r==n){
            res.add(new ArrayList<>(board));
            return;
        }

        int bit = (~(c | lr | ll)) & ((1<<n) - 1);
        while (bit !=0){
            //��ȡ���λ
            int q=bit & (-bit);
            // %ns,q�Ķ�����
            board.add(Integer.toBinaryString(q));
            dfs(n,board,r+1 , c|q ,(lr | q)>>1,(ll | q)<<1);
            board.remove(r);
            bit = bit & (bit-1);
        }
    }

    private void dfs2(int n, List<String> board,
                     int r, int c, int lr, int ll) {
        if(r==n){
            res.add(board);
            return;
        }

        int bit = (~(c | lr | ll)) & ((1<<n) - 1);
        while (bit !=0){
            //��ȡ���λ
            int q=bit & (-bit);
            // %ns,q�Ķ�����
            board.add(String.format("%"+String.valueOf(n)+"s"
                    //��� 0001001  ���0 �滻Ϊ"."
                    , Integer.toBinaryString(q)).replaceAll("[\\s|0]",".")
                .replace("1","Q"));
            dfs(n,new ArrayList<>(board),r+1 , c|q ,(lr | q)>>1,(ll | q)<<1);
            board.remove(r);
            bit = bit & (bit-1);
        }
    }

    public static void main(String[] args) {
        String s = "000010001".replaceAll("[\\s|0]", ".");
        System.out.println(s);
        String.format("%"+String.valueOf(2)+"s","2312");

        new LeetCode_51_379_3().solveNQueens(4);
    }

    private void solve(int row, int ld, int rd) {
        if(row==size){
            count++;
            return;
        }
        int pos=size & (~(row | ld | rd));

        while (pos != 0 ){
            int p=pos & (-pos);
            pos -= p;
            solve(row | p,(ld | p) << 1 ,
                    (rd | p)>> 1);
        }
    }

}