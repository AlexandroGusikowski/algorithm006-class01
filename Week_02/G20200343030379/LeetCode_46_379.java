package G20200343030379;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//46. ȫ����
public class LeetCode_46_379 {
    // ��¼��·����
    private List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new Stack<Integer>());
        return res;
    }

    //�����㷨����·��Ŀ��
    //�ο��ⷨ��https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
    // ·������¼�� track ��
    // ѡ���б�nums �в������� track ����ЩԪ��
    // ����������nums �е�Ԫ��ȫ���� track �г���
    private void backtrack(int[] nums,Stack stack) {
        //�˳�
        // ������������
        if(stack.size()>=nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }

        //ִ���߼�

        //ѭ���ݹ�
        for (int i = 0; i < nums.length; i++) {
            // �ų����Ϸ���ѡ��ջȥ��
            //���������ַ�������Դ�������������ظ���������ջȥ�ء�
            //�����������ظ���������ջȥ�أ�ֻ����int[] ��������ȥ�ء�
            if(stack.contains(nums[i])){
                continue;
            }
            // ��ѡ��
            stack.add(nums[i]);
            // ������һ�������
            backtrack(nums,stack);
            // ȡ��ѡ�񣬳�����ǻ�ѡ��
            stack.pop();
        }

    }

    public List<List<Integer>> permute2(int[] nums) {
        int[] visited=new int[nums.length];
        backtrack2(nums,visited,new Stack<Integer>());
        return res;
    }

    //�����㷨����·��Ŀ��
    //�ο��ⷨ��https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-by-powcai-2/ong-2/
    // ·������¼�� track ��
    // ѡ���б�nums �в������� track ����ЩԪ��
    // ����������nums �е�Ԫ��ȫ���� track �г���
    private void backtrack2(int[] nums,int[] visited,Stack stack) {
        //�˳�
        // ������������
        if(stack.size()>=nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }

        //ִ���߼�

        //ѭ���ݹ�
        for (int i = 0; i < nums.length; i++) {
            // �ų����Ϸ���ѡ������ȥ��--��ӳ��ȥ��
            //���������ַ�������Դ�������������ظ���������ջȥ�ء�
            //�����������ظ���������ջȥ�أ�ֻ����int[] ��������ȥ�ء�
            //1�����߹���0������Լ�����
            if(visited[i]==1){
                continue;
            }
            visited[i]=1;

            // ��ѡ��
            stack.add(nums[i]);
            // ������һ�������
            backtrack2(nums,visited,stack);
            // ȡ��ѡ�񣬳�����ǻ�ѡ��
            visited[i]=0;
            stack.pop();
        }

    }


    public static void main(String[] args) {

    }
}
