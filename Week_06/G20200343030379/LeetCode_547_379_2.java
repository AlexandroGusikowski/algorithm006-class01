package G20200343030379;

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
 */



public class LeetCode_547_379_2 {

    /**
     * ������⣺https://leetcode-cn.com/problems/friend-circles/solution/union-find-suan-fa-xiang-jie-by-labuladong/
     * 1��ƽ�������
     * 2��·��ѹ��
     *
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 99.93% ���û�
     * �ڴ����� : 41.5 MB , ������ Java �ύ�л����� 78.93% ���û�
     * @return
     */
    class UF{
        private int count;
        private int[] size;
        private int[] parent;

        public UF(int n) {
            count=n;
            size=new int[n];
            parent=new int[n];
            for (int i = 0; i < n; i++) {
                //todo
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);

            if(rootP!=rootQ){

                if(size[rootP]>size[rootQ]){
                    //Q�ĸ��ڵ�ָ��P�ĸ����
                    parent[rootQ] = parent[rootP];
                    size[rootQ] += size[rootP];
                }else{
                    parent[rootP] = parent[rootQ];
                    size[rootP] += size[rootQ];
                }

                count--;
            }


        }

        public int find(int x){
            while (parent[x]!=x){
                parent[x]=parent[parent[x]];
                x=parent[x];
            }

            return x;
        }

        public int getCount() {
            return count;
        }
    }

    public int findCircleNum(int[][] M){
        UF uf=new UF(M.length);
        int n = M.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(M[i][j]==1){
                    uf.union(i,j);
                }
            }
        }
        return uf.getCount();
    }

}
