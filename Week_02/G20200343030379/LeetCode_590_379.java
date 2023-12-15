package G20200343030379;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//590. N�����ĺ������
public class LeetCode_590_379 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    //1��ʹ��ջ����
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();

        //����Ҳ������һ��
        if(root==null){
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pollLast();
            //
            res.addFirst(node.val);

            for (Node child : node.children) {
                if(child!=null){
                    stack.add(child);
                }
            }
        }
        return res;
    }

    //2���ݹ鷨
    public List<Integer> postorder2(Node root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        helper(root,res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        for (Node child : root.children) {
            if(child!=null){
                helper(child,res);
            }
        }

        res.add(root.val);
    }


    public static void main(String[] args) {

    }
}
