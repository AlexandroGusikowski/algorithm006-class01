package G20200343030379;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. �������� II
 *
 * ����һ����ά����?board?��һ���ֵ��еĵ����б� words���ҳ�����ͬʱ�ڶ�ά������ֵ��г��ֵĵ��ʡ�
 *
 * ���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ��һ�������в������ظ�ʹ�á�
 *
 * ʾ��:
 *
 * ����:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * ���:?["eat","oath"]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/word-search-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * ����������⣺https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
 */



public class LeetCode_212_379 {
    public static void main(String[] args) {
//        char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    }

    /**
     * ִ����ʱ : 13 ms , ������ Java �ύ�л����� 82.33% ���û�
     * �ڴ����� : 47.6 MB , ������ Java �ύ�л����� 37.02% ���û�
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<>();
        int n = board.length;
        if(n==0) return res;

        int m = board[0].length;



        //����
        TreeNode treeNode = buildTree(words);

        //��鵥���Ƿ�����ǰ׺���������ʺϷ���
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(treeNode,i,j,board,res);
            }
        }
        return res;

    }

    //����λ
    int[][] distances={{-1,0},{1,0},{0,1},{0,-1}};
    //�������й����Ľ��
    private void dfs(TreeNode root, int i ,int j , char[][] board, List<String> res) {
        char c = board[i][j];
        //�Ƿ������һ���������

        if(board[i][j]=='#' || root.next[c - 'a']==null){
            return;
        }

        TreeNode nextNode = root.next[c - 'a'];
        //�ҵ�����һ������
        if(nextNode.word!=null){
            res.add(nextNode.word);
            nextNode.word=null;
            //�����˳�������Ҫ�����ж�
        }

        board[i][j]='#';
        for (int[] d : distances) {
            int xd=i+d[0];
            int yd=j+d[1];

            if(xd>=0 && yd>=0 && xd<board.length  && yd<board[0].length){
                dfs(nextNode,xd,yd,board,res);
            }
        }
        board[i][j]=c;
    }


    //�ַ�������һ����
    public TreeNode buildTree(String[] words){
        TreeNode root=new TreeNode();
        for (String word : words) {
            TreeNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                //System.out.println(p.next.length);
                if(p.next[index]==null){
                    p.next[index]=new TreeNode();
                }
                p=p.next[index];
            }
            p.word=word;
        }
        return root;
    }

    class TreeNode{
        String word;
        TreeNode[] next=new TreeNode[26];
    }
}
