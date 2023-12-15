package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

/**
 *  102. �������Ĳ�α���
 *  ����һ���������������䰴��α����Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
 *
 * ����:
 * ����������:?[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * �������α��������
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *  ������⣺
 */



public class LeetCode_102_379 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //������-�����������
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> queue=new LinkedList();
        //1 ���ͷ���
        queue.add(root);

        //2.����
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            //2.1 ������ǰ��
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //2.1.1 ѡ��ǰ��Ԫ��
                temp.add(node.val);

                //2.1.2 ��ѯ���й���
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            //2.2 �ռ�ÿһ�������
            res.add(temp);
        }

        return res;
    }

    //�ݹ鷨-�����������
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();


        helper(res,root,0);

        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int depth) {
        if(root==null) return;
        if(depth==res.size()) res.add(new ArrayList<>());
        res.get(depth).add(root.val);

        //�ݹ�
        if(root.left!=null) helper(res,root.left,depth+1);
        if(root.right!=null) helper(res,root.right,depth+1);
    }


}
