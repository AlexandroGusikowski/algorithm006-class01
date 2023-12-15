package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *  78. �Ӽ�
 *  ����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
 *  �⼯���ܰ����ظ����Ӽ���
 *
 *  ����: nums = [1,2,3]
 *  ���:
 *  [
 *    [3],
 *    [1],
 *    [2],
 *    [1,2,3],
 *    [1,3],
 *    [2,3],
 *    [1,2],
 *    []
 *  ]
 *
 *
 *  �ο�˼·������https://u.geekbang.org/lesson/10?article=199750
 *  ע�⣺�п��ܶ���ѡ���������������
 */
public class LeetCode_78_379 {
    public static void main(String[] args) {

    }
    /******��һ�ַ�񣺵ݹ�*************/
    public List<List<Integer>> subsets(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        return dsf(nums,new ArrayList<>(),stack,0);
    }

    /**
     * ��һ�ַ�����һ�ַ��д��
     * @param nums Ԫ����
     * @param list ���շ�������
     * @param stack ������ǰ����
     * @param index  ��ǰ�������ڼ���
     * @return
     */
    public List<List<Integer>> dsf(int[] nums,List<List<Integer>> list, Stack<Integer> stack, int index){
        //�˳����������һ�㼴�˳�
        if(index==nums.length){
            list.add(new ArrayList<Integer>(stack));
            return list;
        }

        //ִ�еݹ�
        //��ѡ��ǰԪ�أ�ֱ������һ��
        //stack.add(nums[index]);
        dsf(nums,list, stack, index+1);
        //ѡ��ǰԪ�أ�������һ��
        stack.add(nums[index]);
        dsf(nums,list, stack, index+1);

        //���������
        stack.pop();
        return list;
    }

    /******��һ�ַ����ڶ��ַ�񣺵ݹ�*************/
    public List<List<Integer>> subsets2(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        List<List<Integer>> list=new ArrayList<>();
        dsf2(nums,list,stack,0);
        return list;
    }

    /**
     * �ڶ��ַ��д��
     * @param nums Ԫ����
     * @param list ���շ�������
     * @param stack ������ǰ����
     * @param index  ��ǰ�������ڼ���
     * @return
     */
    public void dsf2(int[] nums,List<List<Integer>> list, Stack<Integer> stack, int index){
        //�˳����������һ�㼴�˳�
        if(index==nums.length){
            list.add(new ArrayList<Integer>(stack));
            return ;
        }

        //ִ�еݹ�
        //��ѡ��ǰԪ�أ�ֱ������һ��
        //stack.add(nums[index]);
        dsf2(nums,list, stack, index+1);
        //ѡ��ǰԪ�أ�������һ��
        stack.add(nums[index]);
        dsf2(nums,list, stack, index+1);

        //���������
        stack.pop();
    }

    /******�ڶ���˼·��������*************/
    public List<List<Integer>> subsets3(int[] nums) {
        //����[1,2,3]
        //�ṹ��ÿ��[]������һ��list���ϣ��ͺ����
        //{[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]}
        //���Ӽ�����ʼ����һ��Ϊ��
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());

        //����nums
        for (int num : nums) {
            //�����洢ÿһ��ļ���
            List<List<Integer>> bigList=new ArrayList();
            //�����Ӽ�
            for (List<Integer> re : res) {
                //�洢ÿ��Ԫ�صļ��ϣ�����˵[1,2]����[2,3]
                List list = new ArrayList<>(re);
                list.add(num);
                bigList.add(list);
            }
            //��ÿһ��ļ��ϣ�׷�ӵ�����Ԫ�ء�
            res.addAll(bigList);
        }

        return res;
    }

}
