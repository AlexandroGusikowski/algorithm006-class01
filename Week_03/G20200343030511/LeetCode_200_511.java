class Solution {
   public int numIslands(char[][] grid) {
		if (grid == null)
			return 0;
		int count = 0;
		// ��¼�����������
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				count += sink(i, j, grid);
			}
		}
		return count;
	}

	private int sink(int i, int j, char[][] grid) {
		int nr = grid.length;
		int nc = grid[0].length;

		// �ݹ���ֹ����
		if ( i >= nr || i < 0 || j >= nc || j < 0||grid[i][j] == '0' )
			return 0;
		// ��ǰ����
		// �ݹ�
		grid[i][j] = '0';
		sink(i + 1, j, grid);
		sink(i - 1, j, grid);
		sink(i, j + 1, grid);
		sink(i, j - 1, grid);
		return 1;
	}
}