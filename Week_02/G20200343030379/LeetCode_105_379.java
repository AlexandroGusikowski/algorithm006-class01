package G20200343030379;

import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

//105. ��ǰ��������������й��������
public class LeetCode_105_379 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private int pre_index=0;
    private int[] preOrder;
    private int[] inOrder;
    private Map<Integer,Integer> inxMap=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder=preorder;
        this.inOrder=inorder;

        for (int i = 0; i < inorder.length; i++) {
            inxMap.put(inorder[i],i);
        }
        return helper(0, inorder.length);

    }

    private TreeNode helper(int left, int right) {
        //�˳�
        if(left==right){
            return null;
        }

        //ִ���߼�
        int val=preOrder[pre_index];
        TreeNode node=new TreeNode(val);
        int index=inxMap.get(val);
        pre_index++;

        //�ݹ�
        node.left=helper(left,index);
        node.right=helper(index+1,right);


        return node;
    }

    public static void main(String[] args) {

    }
}
