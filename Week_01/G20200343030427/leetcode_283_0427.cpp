class Solution {
public:
	void moveZeroes(vector<int>& nums) {
		//˫ָ��
		//��ָ����������ֱ�Ӹ�����ָ��
		//������O(1)
		int len = nums.size();
		int slow = 0;
		for (int fast = 0; fast < len; fast++) {
			if (nums[fast] != 0) {
				nums[slow] = nums[fast];
				slow++;
			}
		}
		//�Ѻ��涼��Ϊ0
		for (int i = slow; i < len; i++) {
			nums[i] = 0;
		}
	}
};