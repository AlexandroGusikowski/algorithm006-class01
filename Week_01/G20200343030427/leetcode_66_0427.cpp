//ֻ�����������1.��λ��Ϊ9��
//1.1  ����+1���λ��
//1.2 ���ǽ�λ��λ�������仯
//2.��λ����Ϊ9

class Solution {
public:
	vector<int> plusOne(vector<int>& digits) {

		for (int tail = digits.size() - 1; tail >= 0; tail--) {
			digits[tail] = (digits[tail] + 1) % 10;
			if (digits[tail] != 0)
				break;
			if (digits[tail] == 0) {
				if (tail == 0)
					digits.insert(digits.begin(), 1);
			}
		}
		return digits;
	}
};