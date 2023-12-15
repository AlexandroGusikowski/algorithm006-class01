class Solution {
    // ���������ҵ�P�����ȣ����ҵ�q�����ȣ����P��q�����������һ����
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || p == null || q == null)
			return null;

		ArrayList<TreeNode> pList = new ArrayList<>();
		boolean pfound =search(root, p,pList);
		ArrayList<TreeNode> qList = new ArrayList<>();
		boolean qfound =search(root, q,qList);

		if (!pfound && !qfound) {
			return null;
		}

		// �ҵ������ڵ������һ����ͬ�Ľڵ�
		int psize = pList.size() - 1;
		int qsize = qList.size() - 1;
		for (int i = psize; i >= 0; i--) {
			for (int j = qsize; j >= 0; j--) {
				if (pList.get(i).val == qList.get(j).val) {
					return pList.get(i);
				}
			}
		}
		return null;
	}

	private boolean search(TreeNode root, TreeNode node, ArrayList<TreeNode> list) {
		// �ݹ���ֹ����
		if (root.val == node.val){
			list.add(root);
			return true;
		}
		// ��ǰ����
         list.add(root);
         boolean found =false;
		// �ݹ�
         if(root.left!=null) found=search(root.left, node, list);
         if(!found&&root.right!=null) found=search(root.right, node, list);
		// ���״̬��
		if(!found) list.remove(list.size()-1);		
		return found;				
	}
	
	//�򻯰�
		public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null)
			return null;
		return help(root, p, q);
	}

	private TreeNode help(TreeNode root, TreeNode p, TreeNode q) {
		// ��ֹ����
		if (root == null || root == q || root == p)
			return root;
		// ��ǰ����
		// �ݹ�
		TreeNode l = help(root.left, p, q);
		if (l != null && l != p && l != q)
			return l;
		TreeNode r = help(root.right, p, q);
		if (l != null && r != null)
			return root;
		else {
			return l == null ? r : l;
		}
	}
}