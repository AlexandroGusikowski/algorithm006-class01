/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length)
			return null;
		return help(preorder, 0, preorder.length, inorder, 0, inorder.length);
	}

	private TreeNode help(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
		// ��ֹ����
		if (pre_start == pre_end)
			return null;
		// ��ǰ����
		TreeNode node = new TreeNode(preorder[pre_start]);
		int index;
		for (index = in_start; index <= in_end; index++)
			if (preorder[pre_start] == inorder[index])
				break;
		
		
		// ��仰
		int leftNum = index - in_start;
		// �ݹ�
		node.left = help(preorder, pre_start + 1, pre_start+leftNum+1, inorder, in_start, index);
		node.right = help(preorder, pre_start + leftNum + 1, pre_end, inorder, index + 1, in_end);
		// ״̬����
		return node;
	}
}
