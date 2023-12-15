package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//47. ȫ���� II

/***
 * �����㷨��ܣ�
 * result = []
 * def backtrack(·��, ѡ���б�):
 *     if �����������:
 *         result.add(·��)
 *         return
 *
 *     for ѡ�� in ѡ���б�:
 *         ��ѡ��
 *         backtrack(·��, ѡ���б�)
 *         ����ѡ��
 *
 * ���ߣ�labuladong
 * ���ӣ�https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
 * ��Դ�����ۣ�LeetCode��
 * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
 */
public class LeetCode_47_379 {
    public static void main(String[] args) {
        new LeetCode_47_379().permuteUnique(new int[]{1,2,1});
    }
    private List<List<Integer>> res=new ArrayList<>();
    private Set<String> set=new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] visited=new int[nums.length];
        //��Ϊ�㷨�Ǹ���ǰ���ֵ�ж��Ƿ��ظ������Ա������ź���
        Arrays.sort(nums);
        backtrack(nums,visited,new Stack<Integer>());
        System.out.println(res);
        return res;
    }

    //�����㷨����·��Ŀ��
    //�ο��ⷨ��https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
    //index �Ƿ�������
    private void backtrack(int[] nums,int[] visite,Stack stack) {
        /**�˳�,���ɸѡ���ܺ�ʱ��**/
        if(stack.size()>=nums.length){
            if(!set.contains(stack.toString())){
                res.add(new ArrayList<>(stack));
                set.add(stack.toString());
            }
            return;
        }

        //ִ���߼�

        //ѭ���ݹ�
        // for ѡ�� in ѡ���б�:
        for (int i = 0; i < nums.length; i++) {
            //�������������ظ��ģ������ø÷����ų����Ϸ���ѡ��
            if(visite[i]==1){
                continue;
            }
            visite[i]=1;
            stack.add(nums[i]);

            //������һ�������
            backtrack(nums,visite,stack);

            //����ѡ��
            visite[i]=0;
            stack.pop();
        }

    }

    //�����㷨����·��Ŀ��,�Ż��汾
    //�ο��ⷨ��https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-by-powcai-3/
    //index �Ƿ�������
    private void backtrack2(int[] nums,int[] visite,Stack stack) {
        /**�˳�,���ɸѡ���ܺ�ʱ��**/
        /*if(stack.size()>=nums.length){
            if(!set.contains(stack.toString())){
                res.add(new ArrayList<>(stack));
                set.add(stack.toString());
            }
            return;
        }*/
        if(stack.size()>=nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }

        //ִ���߼�

        //ѭ���ݹ�
        for (int i = 0; i < nums.length; i++) {
            //�������������ظ��ģ������ø÷����ų����Ϸ���ѡ��
            //visite[i]==1 ����ǰ�ڵ��߹���visite[i-1]==0 �������ֵ��Ѿ����꣬�Ѿ���1��ֵΪ0�����ҵ�ǰ�ڵ�����ֵܽڵ�һ���������ظ���
            if(visite[i]==1 || (i>0 && visite[i-1]==0 && nums[i-1]==nums[i])){
                continue;
            }

            visite[i]=1;
            stack.add(nums[i]);

            //������һ��
            backtrack2(nums,visite,stack);

            //����ѡ��
            visite[i]=0;
            stack.pop();
        }


    }

}
