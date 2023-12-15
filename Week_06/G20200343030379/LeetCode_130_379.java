package G20200343030379;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 130. ��Χ�Ƶ�����
 *
 *����һ����ά�ľ��󣬰��� 'X' �� 'O'����ĸ O����
 *
 * �ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е� 'O' �� 'X' ��䡣
 *
 * ʾ��:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * ������ĺ����󣬾����Ϊ��
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * ����:
 *
 * ��Χ�Ƶ����䲻������ڱ߽��ϣ����仰˵���κα߽��ϵ� 'O' �����ᱻ���Ϊ 'X'�� �κβ��ڱ߽��ϣ�����߽��ϵ� 'O' ������ 'O' ���ն��ᱻ���Ϊ 'X'���������Ԫ����ˮƽ��ֱ�������ڣ���������ǡ��������ġ�
 *
 */



public class LeetCode_130_379 {
    public static void main(String[] args) {
        char[][] ch={{'1','1'},{'1','1'},{'1','0'}};
//        char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    }

    class UF{
        private int parent[];
        private int size[];
        private int count;

        public UF(int n,int m) {
            parent=new int[n*m];
            size=new int[n*m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    parent[i*m+j]=i*m+j;
                    size[i*m+j]=1;
                }
            }
        }

        public UF(char[][] board) {
            int n = board.length;
            int m = board[0].length;
            parent=new int[n*m];
            size=new int[n*m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    parent[i*m+j]=i*m+j;
                    size[i*m+j]=1;
                    if(board[i][j]=='0'){
                        count++;
                    }
                }
            }
        }

        //�ϲ�
        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP!=rootQ){

                if(size[rootP]>size[rootQ]){
                    parent[rootQ]=parent[rootP];
                    size[rootP]+=size[rootQ];

                }else{
                    parent[rootP]=parent[rootQ];
                    size[rootQ]+=size[rootP];
                }
               //��ʱ���� count--;
            }
        }

        //��ѯ���ڵ�
        public int find(int x){
            while (x!=parent[x]){
                parent[x]=parent[parent[x]];
                x=parent[x];
            }
            return x;
        }

        //��������ڵ��Ƿ�ͬһ������
        public boolean isConnected(int p,int q){
           return find(p)==find(q);
        }
    }

    /***
     * ���鼯��
     *
     * ������⣺
     * �������ֽⷨ�����鼯��https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/
     * ִ����ʱ : 14 ms , ������ Java �ύ�л����� 10.36% ���û�
     * �ڴ����� : 41.9 MB , ������ Java �ύ�л����� 37.60% ���û�
     * @param board
     */
    public void solve(char[][] board) {
        if(board.length==0) return;

        int n = board.length;
        int m = board[0].length;
        int endBorad=n*m-1;
        UF uf=new UF(n,m);

        //����λ
        int[][] distances={{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]=='O'){

                    int p=i*m+j;
                    //System.out.println(i+" "+j);
                    //�ѱ߽��'0'�����½�λ�� �ϲ�
                    if(i==0 || i==n-1 || j==0 || j==m-1){
                        //System.out.println(i+"=="+j);
                        uf.union(p,endBorad);
                    }else{
                        //�ѱ߽��ڵ�'0'�ϲ�����������

                        for (int[] d : distances) {
                            int px = i+d[0];
                            int qy = j+d[1];

                            //ע�⣺����ҲҪ����ٽ�ڵ��Ƿ��ǡ�O��������������ѡ�1����ǰͬһ��
                            if(board[px][qy]!='O') continue;

                            //ע�⣺����Ҫ��==0�����һ���ж���Ҳ���Ǳ߽�ֵ�����
                            if(px>=0 && px<n && qy>=0 && qy<m){
                                uf.union(p,px*m+qy);
                            }
                        }

                    }

                }

            }
        }


        //���߽��ڵģ����Ҳ������½ǹ��������Ϊ'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if(board[i][j]=='O' && !uf.isConnected(i*m+j,endBorad)){
                   board[i][j]='X';
               }
            }
        }
        return;

    }
}
