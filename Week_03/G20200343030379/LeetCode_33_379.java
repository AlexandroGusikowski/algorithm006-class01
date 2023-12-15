package G20200343030379;

import org.omg.CORBA.IRObject;

import javax.swing.*;
import java.util.List;

/**
 *  33. ������ת��������
 *
 *  ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 *
 * ( ���磬����?[0,1,2,4,5,6,7]?���ܱ�Ϊ?[4,5,6,7,0,1,2]?)��
 *
 * ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻�?-1?��
 *
 * ����Լ��������в������ظ���Ԫ�ء�
 *
 * ����㷨ʱ�临�Ӷȱ�����?O(log?n) ����
 *
 * ʾ�� 1:
 *
 * ����: nums = [4,5,6,7,0,1,2], target = 0
 * ���: 4
 * ʾ��?2:
 *
 * ����: nums = [4,5,6,7,0,1,2], target = 3
 * ���: -1
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺
 *
 */
public class LeetCode_33_379 {
    public static void main(String[] args) {
        new LeetCode_33_379().search2(new int[]{4,5,6,7,0,1,2},0);
    }

    /**
     * ������-��ԭ
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return 1;
    }

    /**
     * ���ֲ��ҷ�
     *
     * ����: nums = [4,5,6,7,0,1,2], target = 0
     * ���: 4
     * ʾ��?2:
     *
     * ������⣺���ֲ��ң�https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid=0;
        while (left<=right){
            mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;

            }else if(nums[left] <= nums[mid]){
                //���ߵ�������
                //�������ߵķ�Χ
                if(nums[left]<=target && nums[mid] > target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                //�Ұ�ߵ�������

                // �ж��Ƿ����Ұ�ߵķ�Χ��
                if(nums[mid] < target && nums[right] >= target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }

        }
        return -1;
    }


}
