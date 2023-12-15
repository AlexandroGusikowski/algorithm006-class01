package G20200343030379;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  55. ��Ծ��Ϸ
 *
 *  ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * �ж����Ƿ��ܹ��������һ��λ�á�
 *
 * ʾ��?1:
 *
 * ����: [2,3,1,1,4]
 * ���: true
 * ����: ���ǿ������� 1 ������λ�� 0 ���� λ�� 1, Ȼ���ٴ�λ�� 1 �� 3 ���������һ��λ�á�
 * ʾ��?2:
 *
 * ����: [3,2,1,0,4]
 * ���: false
 * ����: �������������ܻᵽ������Ϊ 3 ��λ�á�����λ�õ������Ծ������ 0 �� ��������Զ�����ܵ������һ��λ�á�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/jump-game
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *  ������⣺
 *
 *
 */



public class LeetCode_55_379 {

    /**
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 99.96% ���û�
     * �ڴ����� : 41.1 MB , ������ Java �ύ�л����� 22.40% ���û�
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int lastIndex=nums.length-1;
        for (int i = lastIndex-1; i >= 0; i--) {
            if(i+nums[i]>=lastIndex){
                lastIndex=i;
            }

        }
        return lastIndex==0;
    }

}
