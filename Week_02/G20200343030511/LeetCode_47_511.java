class Solution {
    List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums.length == 0 || nums == null)
			return result;
		List<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		help(nums, list,visited);
		return result;
	}

	private void help(int[] nums, List<Integer> list,boolean[] visited) {
		// �жϷ�������,��ʾ���е�ѡ�������Ѿ�ѡ�������,����һ���µ�list
		if (nums.length == list.size()) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			//ȥ�������ϵ�������
			if(i>0&&nums[i]==nums[i-1]&&!visited[i-1]) continue;
			if(visited[i]) continue;
			list.add(nums[i]);
			visited[i]=true;
			help(nums, list,visited);
			// ����ѡ��
			list.remove(list.size() - 1);
			visited[i]=false;
		}
	}
}