class Solution {
     //�������,ʵ���Ͼ��ǲ������,ÿһ����������ͺ�
	public List<Integer> postorderTraversal(TreeNode root) {
		//�����ʱ����ջ���룬�����ʱ����list
		LinkedList<Integer> list = new LinkedList<>();
		if(root==null) return list;
		Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
        	root =stack.pop();
        	list.addFirst(root.val);
        	if(root.left!=null) stack.push(root.left); 
        	if(root.right!=null) stack.push(root.right);          	        	      	      	
        }
		return list;
	}
	
	//�������
	
	public List<Integer> postorderTraversal2(TreeNode root) {
	    List<Integer> list = new ArrayList<>();
	    Stack<TreeNode> stack = new Stack<>();
	    TreeNode cur = root;
	    TreeNode last = null;
	    while (cur != null || !stack.isEmpty()) {
	        if (cur != null) {
	            stack.push(cur);
	            cur = cur.left;
	        } else {
	            TreeNode temp = stack.peek();
	            //�����������Ϊ�գ����� temp.right != last(���˵��,����ڵ㲻�Ǵ�������������.)       
	            //����Ҫ�䵽������.
	            if (temp.right != null && temp.right != last) {
	                cur = temp.right;
	            } else {
	            	/*����ڵ��������϶�Ϊ�գ����������Ϊ�գ�˵����Ҷ�ӽڵ㣬���������
	            	 * ������������ϴη��ʵĽڵ㣬˵���������Ѿ����������Ǹ�����Ҫ����ˡ�
	            	 * */
	                list.add(temp.val);
	                last = temp;
	                /*Ϊʲôֻ����������¶�last���и�ֵ�أ�
	                 * ��Ϊ��ǰ���������ڵ�϶�û��������������ֻ�����������������
	                 * �����һ�α���������ڵ�Ϳ϶���Ҷ�ӽڵ㡣
	                 * ��������ӡ�ʵ����û���á�
	                 * ������Һ��ӣ�����ζ��������Һ��Ӻ󣬻���Ҫ�ص����׽ڵ㡣
*/	                stack.pop();
	            }
	        }
	    }
	    return list;
	}
}