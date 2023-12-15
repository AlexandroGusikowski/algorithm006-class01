package G20200343030379;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 22. ��������
 * ����?n?�����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
 *
 * ���磬����?n = 3�����ɽ��Ϊ��
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/generate-parentheses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 */
public class LeetCode_22_379 {
    public static void main(String[] args) {
        List<String> strings = new LeetCode_22_379().generateParenthesis2(3);
        System.out.println(strings);


    }

    /**
     * �ݹ鷨-->����������� DFS
     */
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        dfs(res,n,n,n*2,"");
        return res;
    }

    /**
     *
     * @param res �����
     * @param left ����ж��ٸ�������
     * @param right �ұ��ж��ٸ�������
     * @param n �ܵĸ����������ж��Ƿ����
     * @param curStr ��ǰ�����ַ���
     */
    private void dfs(List<String> res, int left, int right, int n, String curStr) {
        //��������
        if(curStr.length()==n){
            res.add(curStr);
            return ;
        }

        //��ߵ������Ѿ����꣬ÿ�������ż�1��left-1
        if(left>0){
            dfs(res,left-1,right,n,curStr+"(");
        }
        //�ұߵ������Ѿ�����,���ұ��������ʹ�������ŵ����(left<right)��ÿ�������ż�1��right-1
        if(right>0 && left<right){
            dfs(res,left,right-1,n,curStr+")");
        }

    }



    /**
     * ���б�����-->����������� BFS
     * ��Ϊ���ǵݹ���ã�û�취���ö��д��ݶ��������Ϊ�˷���������Լ�����һ�����ṹ�����������Ŀ��Ի�ȡ��Ӧ��ֵ��
     *  ���磺1����ǰ�ַ��� 2������������ 3��������������
     *
     *  �ο���⣺https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
     */

    class Node {
        /**
         * ��ǰ�õ����ַ���
         */
        private String res;
        /**
         * ʣ������������
         */
        private int left;
        /**
         * ʣ������������
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node("",n,n));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.left==0 && node.right==0){
                res.add(node.res);
            }

            if(node.left>0){
                queue.offer(new Node(node.res+"(",node.left-1,node.right));
            }
            if(node.right>0 && node.left<node.right){
                queue.offer(new Node(node.res+")",node.left,node.right-1));
            }
        }
        return res;

    }

}
