package G20200343030379;

/**
 * 200. ��������
 *
 *����һ���� '1'��½�أ��� '0'��ˮ����ɵĵĶ�ά���񣬼��㵺���������һ������ˮ��Χ����������ͨ��ˮƽ�����ֱ���������ڵ�½�����Ӷ��ɵġ�����Լ���������ĸ��߾���ˮ��Χ��
 *
 * ʾ�� 1:
 *
 * ����:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * ���: 1
 * ʾ�� 2:
 *
 * ����:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * ���: 3
 *
 *  ������⣺https://leetcode-cn.com/problems/number-of-islands/
 */



public class LeetCode_200_379 {
    public static void main(String[] args) {
        char[][] ch={{'1','1'},{'1','1'},{'1','0'}};
//        char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int i = new LeetCode_200_379().numIslands(ch);
        System.out.println(i);
    }


    class UF{
        private int count;
        private int[] size;
        private int[] parent;

        public UF(char grid[][]) {
            int n = grid.length;
            int m = grid[0].length;
            size=new int[n*m];
            parent=new int[n*m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    parent[i * m + j] = i * m + j;
                    size[i * m + j] = 1;
                    ///�ؼ����룬���״�
                    if(grid[i][j]=='1'){
                        count++;
                    }
                }
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

    /**
     * ����λд��
     * ���ȣ�ʱ��Ч�ʿ���1��
     *
     * ����ο���⣺https://leetcode.com/problems/number-of-islands/discuss/56354/1D-Union-Find-Java-solution-easily-generalized-to-other-problems
     *
     * ִ����ʱ : 6 ms , ������ Java �ύ�л����� 25.47% ���û�
     * �ڴ����� : 42.2 MB , ������ Java �ύ�л����� 5.02% ���û�
     */
    int[][] distance = {{-1,0},{1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        UF uf=new UF(grid);
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    for (int[] d : distance) {
                        int p= i+d[0];
                        int q= j+d[1];
                        if(p>=0 && p<n && q>=0 && q<m && grid[p][q]=='1'){
                            uf.union(i*m+j,p*m+q);
                        }

                    }
                }
            }
        }
        return uf.getCount();
    }

    /**
     *
     * �ο���⣺https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/
     * @param grid
     * @return
     * ���鼯
     * ִ����ʱ : 7 ms , ������ Java �ύ�л����� 17.80% ���û�
     * �ڴ����� : 42.3 MB , ������ Java �ύ�л����� 5.02% ���û�
     */
    public int numIslands2(char[][] grid) {
        if(grid.length==0) return 0;
        UF uf=new UF(grid);
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'){

                    int p= i*m+j;
                    grid[i][j]='0';
                    if (i>0 && grid[i-1][j]=='1'){
                        uf.union(p, (i-1)*m+j);
                    }
                    if(i+1<n && grid[i+1][j]=='1'){
                        uf.union(p, (i+1)*m+j);
                    }
                    if(j-1>0 && grid[i][j-1]=='1'){
                        uf.union(p, i*m+(j-1));
                    }
                    if(j+1<m && grid[i][j+1]=='1'){
                        uf.union(p, i*m+(j+1));
                    }
                }
            }
        }
        return uf.getCount();
    }
}
