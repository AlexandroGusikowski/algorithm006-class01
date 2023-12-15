package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *  169. ����Ԫ��
 *
 *  ����һ����СΪ n �����飬�ҵ����еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ�������?? n/2 ??��Ԫ�ء�
 *
 *  ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
 *
 *  ʾ��?1:
 *
 *  ����: [3,2,3]
 *  ���: 3
 *  ʾ��?2:
 *
 *  ����: [2,2,1,1,1,2,2]
 *  ���: 2
 *
 *  ��Դ�����ۣ�LeetCode��
 *  ���ӣ�https://leetcode-cn.com/problems/majority-element
 *  ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *  ������⣺https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
 */
public class LeetCode_169_379 {
    public static void main(String[] args) {

    }

    /***
     * ��һ�ֹ�ϣ����ʹ�ù�ϣ��洢���ֳ��ִ���
     * ִ����ʱ : 18 ms , ������ Java �ύ�л����� 33.40% ���û�
     * �ڴ����� : 47 MB , ������ Java �ύ�л����� 5.10% ���û�
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int num : nums) {
            //�洢���ִ���
            if(map.get(num)!=null){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }

        //���ҳ�����n/2�����Ҵ����������֡�
        int n=0;
        //���ִ���n/2�Ĵ�����Ĭ��Ϊ��Сֵ
        int count=Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer integerCount = map.get(entry.getKey());
            //����Ҫ������n/2����Ҫ���ִ�������
            //ps��&& integerCount>count  ������ʵ���Բ��ÿ��ǣ���Ϊ��Ҫ�������ϣ����Բ����ܳ���ǰ����ڰ����������ִ��ڰ����������������ȫ���ÿ���
            if(integerCount>(nums.length/2) && integerCount>count){
                n=entry.getKey().intValue();
                //��¼����������
                count=integerCount;
            }
        }


        return n;
    }
    /***
     * �ڶ��ֹ�ϣ����ʹ�ù�ϣ��洢���ֳ��ִ�������ʡ��һ������������ʵ�ʲ�����ķ������ˣ�û�㶮
     * ִ����ʱ : 22 ms , ������ Java �ύ�л����� 22.64% ���û�
     * �ڴ����� : 47.3 MB , ������ Java �ύ�л����� 5.10% ���û�
     */
    public int majorityElement3(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int major=0;
        for (int num : nums) {
            //�洢���ִ���
            if(map.get(num)!=null){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
            if(map.get(num)>nums.length/2){
                major=num;
                //��Ϊ��Ҫ�������ϣ����Բ����ܳ���ǰ����ڰ����������ִ��ڰ����������������ȫ���ÿ���
                break;
            }
        }

        return major;
    }

    /***
     * ����������������ѧ������õ������У�n������ʱ���������±�Ϊ n/2 ,�� n ��ż��ʱ���±�Ϊ (n/2)+1 ��
     * ��ʵ��������λ���� ��n/2���㼴��
     * 	2 ms	41.8 MB	Java
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
