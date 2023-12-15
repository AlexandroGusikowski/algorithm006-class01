package G20200343030379;

import java.util.Arrays;

/**
 *  208. ʵ�� Trie (ǰ׺��)
 *
 *  ʵ��һ�� Trie (ǰ׺��)������ insert, search, �� startsWith ������������
 *
 * ʾ��:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // ���� true
 * trie.search("app");     // ���� false
 * trie.startsWith("app"); // ���� true
 * trie.insert("app");
 * trie.search("app");     // ���� true
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description
 *
 *  ������⣺https://leetcode.com/problems/implement-trie-prefix-tree/discuss/58832/AC-JAVA-solution-simple-using-single-array
 */



public class LeetCode_208_379 {
    class TrieNode{
        public char val;
        public boolean isWord;
        public TrieNode[] childern =new TrieNode[26];
        public TrieNode(){}
        public TrieNode(char c){
            this.val=c;
        }
    }

    class Trie {
        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root=new TrieNode();
            root.val=' ';
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode ws=root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(ws.childern[c - 'a']==null){
                    ws.childern[c - 'a']=new TrieNode(c);
                }
                ws=ws.childern[c - 'a'];
            }
            ws.isWord=true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode ws=root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(ws.childern[c-'a']!=null){
                    ws=ws.childern[c-'a'];
                }else{
                    return false;
                }
            }
            return ws.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode ws=root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(ws.childern[c-'a']==null){
                    return false;
                }else{
                    ws=ws.childern[c-'a'];
                }
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

}
