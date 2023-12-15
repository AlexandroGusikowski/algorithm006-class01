class Solution {
    List<List<Integer>> result = new ArrayList<>();	
	public List<List<Integer>> permute(int[] nums) {
		if(nums.length==0||nums ==null) return result;
		List<Integer> list = new ArrayList<>();		
		help(nums,list);		
		return result;
	}
	private void help(int[] nums, List<Integer> list) {
		//�жϷ�������,��ʾ���е�ѡ�������Ѿ�ѡ�������
		if(nums.length==list.size()){
			result.add(new ArrayList(list));
			return; 
		}	
		for (int i = 0; i < nums.length; i++) {
			//��ʾ�Ѿ�ѡ���ˡ���Ϊ���ظ���
			if(list.contains(nums[i])) continue;
            list.add(nums[i]);
			help(nums,list);
			//����ѡ��
			list.remove(list.size()-1);			
		}		
	}
}