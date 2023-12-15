package G20200343030379;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Arrays;

/**
 *  547. ����Ȧ
 * ������ N ��ѧ����������Щ�������ѣ���Щ���ǡ����ǵ���������Ǵ����ԡ������֪ A �� B �����ѣ�B �� C �����ѣ���ô���ǿ�����Ϊ A Ҳ�� C �����ѡ���ν������Ȧ����ָ�������ѵļ��ϡ�
 *
 * ����һ�� N * N �ľ��� M����ʾ�༶��ѧ��֮������ѹ�ϵ�����M[i][j] = 1����ʾ��֪�� i ���� j ��ѧ����Ϊ���ѹ�ϵ������Ϊ��֪����������������ѧ���е���֪������Ȧ������
 *
 * ʾ�� 1:
 *
 * ����:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * ���: 2
 * ˵������֪ѧ��0��ѧ��1��Ϊ���ѣ�������һ������Ȧ��
 * ��2��ѧ���Լ���һ������Ȧ�����Է���2��
 * ʾ�� 2:
 *
 * ����:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * ���: 1
 * ˵������֪ѧ��0��ѧ��1��Ϊ���ѣ�ѧ��1��ѧ��2��Ϊ���ѣ�����ѧ��0��ѧ��2Ҳ�����ѣ���������������һ������Ȧ������1��
 * ע�⣺
 *
 * N ��[1,200]�ķ�Χ�ڡ�
 * ��������ѧ������M[i][i] = 1��
 * �����M[i][j] = 1������M[j][i] = 1��
 *
 *
 *  ������⣺https://leetcode-cn.com/problems/friend-circles/
 *  ����������⣺https://leetcode.com/problems/friend-circles/discuss/101336/Java-solution-Union-Find
 */



public class LeetCode_547_379 {
    /**
     * ���鼯д������ͨд���е�Ч������
     *
     * ִ����ʱ : 10 ms , ������ Java �ύ�л����� 15.48% ���û�
     * �ڴ����� : 41.9 MB , ������ Java �ύ�л����� 78.33% ���û�
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int[] parent=new int[M.length];
        Arrays.fill(parent,-1);


        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if(M[i][j]==1 && i!=j){
                    union(parent,i,j);
                }
            }
        }

        int count=0;
        for (int i : parent) {
            //�Ǹ��ڵ㣬˵������һ����
            if(i==-1){
                count++;
            }
        }
        return count;
    }

    public void union(int[] parent,int i,int j){
        //Ѱ��x��ĸ��ڵ�λ��
        int setx=find(parent,i);
        //Ѱ��y��ĸ��ڵ�λ��
        int sety=find(parent,j);

        if(setx!=sety){
            parent[setx]=sety;
        }
    }


    public int find(int[] parent,int i){
        if(parent[i]==-1){
            return i;
        }
        return find(parent,parent[i]);
    }


    /**
     * �������
     * 1��ƽ�������
     * 2��·��ѹ��
     * @return
     */
    class UnionFind{
        private int count=0;
        private int[] parent,rank;

        public UnionFind(int n) {
            this.count = n;
            parent=new int[n];
            rank=new int[n];
            for (int i = 0; i < n; i++) {
                parent[i]=i;
            }
        }

        public int find2(int p){
            while (p!=parent[p]){
                parent[p]=parent[parent[p]];
                p=parent[p];
            }
            return p;
        }

        public void union(int p,int q){
            int rootP=find2(p);
            int rootQ=find2(q);

            if(rootP==rootQ) return;

            if(rank[rootQ] >rank[rootP]){
                parent[rootP]=rootQ;
            }else{
                parent[rootQ]=rootP;
                if(rank[rootP]==rank[rootQ]){
                    rank[rootP]++;
                }
            }
            count--;
        }

        public int count(){
            return count;
        }
    }

    public int findCircleNum2(int[][] M) {
        int n=M.length;
        UnionFind uf=new UnionFind(n);
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(M[i][j]==1) uf.union(i,j);
            }
        }
        return uf.count();
    }

    public static void main(String[] args) {
        char a='1';
        System.out.println(a);
    }

}
