class Solution {
     int n;
    int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    PutO(i, j, grid);
                    //���õݹ�
                }

            }

            return count;
    }

    private void PutO(int i, int j, char[][] grid) {
        //��ֹ���� �ݹ�ĵݿ���ͣ�ˣ���ʼ����
        if (i >= n || j >= m || i < 0 || j < 0  || grid[i][j] == '0') return;;

        //��ǰ�㴦��
        grid[i][j] = '0';

        //������һ��
        PutO(i+1, j, grid);
        PutO(i-1, j, grid);
        PutO(i, j+1, grid);
        PutO(i, j-1, grid);

        //�ݹ�������������һ���Ӱ��
    }
}