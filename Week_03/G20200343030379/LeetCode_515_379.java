package G20200343030379;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *  515. ��ÿ�������������ֵ
 *
 *  ����Ҫ�ڶ�������ÿһ�����ҵ�����ֵ��
 *
 * ʾ����
 *
 * ����:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * ���: [1, 3, 9]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *  ������⣺
 */



public class LeetCode_515_379 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
    }

    /**
     * ������-�����������(ע�⣺����������־���ɺ�����ע�ⲻҪ��)
     *
     * ִ����ʱ : 2 ms , ������ Java �ύ�л����� 82.08% ���û�
     * �ڴ����� : 41.8 MB , ������ Java �ύ�л����� 5.13% ���û�
     *
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        //ÿһ������ֵ
        while (!queue.isEmpty()){
            int maxValue=Integer.MIN_VALUE;
            int size = queue.size();
            //������ǰ��
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //��־��ӡ��Ӱ�� ִ����ʱ�����ȥ��ִ����־
                //System.out.println("����");
                //��ȡ��ǰ������ֵ
                if(node.val>maxValue) {
                    maxValue=node.val;
                }

                //��ȡ��������һ���ӽڵ�
                if(node.left!=null) {queue.add(node.left);}
                if (node.right != null) {queue.add(node.right);}

            }
            res.add(maxValue);
        }

        return res;
    }


    /**
     *  �ݹ鷨-�����������
     *  ִ����ʱ : 1 ms , ������ Java �ύ�л����� 100.00% ���û�
     *  �ڴ����� : 42.6 MB , ������ Java �ύ�л����� 5.13% ���û�
     *
     *  �ο���⣺
     *  https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/solution/java-di-gui-xie-fa-hao-shi-2ms-by-ou-ran-zz/
     *  https://leetcode.com/problems/find-largest-value-in-each-tree-row/discuss/98971/9ms-JAVA-DFS-solution
     *
     */
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(res,root,0);

        return res;
    }

    private void dfs(List<Integer> res, TreeNode root, int level) {
        if(root==null){
            return;
        }
        if(level==res.size()){
            res.add(root.val);
        }else{
            res.set(level,Math.max(res.get(level),root.val));
        }

        if(root.left!=null){
            dfs(res,root.left,level+1);
        }
        if(root.right!=null){
            dfs(res,root.right,level+1);
        }
    }


}
