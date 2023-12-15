package G20200343030379;

import java.util.Arrays;

/**
 *  153. Ѱ����ת���������е���Сֵ
 *
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 *
 * ( ���磬����?[0,1,2,4,5,6,7] ���ܱ�Ϊ?[4,5,6,7,0,1,2]?)��
 *
 * ���ҳ�������С��Ԫ�ء�
 *
 * ����Լ��������в������ظ�Ԫ�ء�
 *
 * ʾ�� 1:
 *
 * ����: [3,4,5,1,2]
 * ���: 1
 * ʾ�� 2:
 *
 * ����: [4,5,6,7,0,1,2]
 * ���: 0
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺
 *
 */
public class LeetCode_153_379 {

    /**
     * ����
     *
     * ִ����ʱ : 2 ms , ������ Java �ύ�л����� 26.08% ���û�
     * �ڴ����� : 38 MB , ������ Java �ύ�л����� 32.06% ���û�
     *
     * @return
     */
    public int findMin(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        return nums[0];
    }

    /**
     * ���ֲ��ҷ������߲��ϼбƽӽ���Сֵ
     *
     * ִ����ʱ : 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 38 MB , ������ Java �ύ�л����� 32.24% ���û�
     *
     * ������⣺https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-by-powcai-2/
     *
     * @return
     */
    public int findMin2(int[] nums) {
        int left=0,right=nums.length-1;
        int mid=0;
        //�������ֵ��ȼ����˳��������жϽ�ѭ����������������ⲿreturn�������ѭ�����������ѭ����return����
        while (left<right){
            mid = (left + right) / 2;

            //�ұߵ�������,˵����С������
            if(nums[mid] < nums[right]){
                right = mid  ;
            }else{
                //����Ҫ��1
                left = mid + 1 ;
            }
        }

        //left right ���ض�����
        return nums[left];
    }


}
