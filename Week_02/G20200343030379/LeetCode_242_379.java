package G20200343030379;

import java.util.Arrays;

//Java����Ч����ĸ��λ��
public class LeetCode_242_379 {
        public static void main(String[] args) {
            //Solution solution = new P242ValidAnagram().new Solution();
            // TO TEST
            String s="abcd";
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                System.out.println(aChar-'a');
            }

        }
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            //��ϣ������  ʵ���Ǽ�������
            public boolean isAnagram(String s, String t) {
                if(s.length()!=t.length()){
                    return false;
                }

                int[] counter=new int[26];
                for (int i = 0; i < s.length(); i++) {
                    counter[s.charAt(i)-'a']++;
                }

                for (int i = 0; i < t.length(); i++) {
                    counter[t.charAt(i)-'a']--;
                    if(counter[t.charAt(i)-'a']<0){
                        return false;
                    }
                }
                return true;
            }
            //��ϣ��  ʵ���Ǽ�������
            public boolean isAnagram3(String s, String t) {
                if(s.length()!=t.length()){
                    return false;
                }

                int[] counter=new int[26];
                for (int i = 0; i < s.length(); i++) {
                    counter[s.charAt(i)-'a']++;
                    counter[t.charAt(i)-'a']--;
                }

                for (int c : counter) {
                    if(c!=0){
                        return false;
                    }
                }
                return true;
            }
            //����
            public boolean isAnagram2(String s, String t) {
                char[] a = s.toCharArray();
                char[] b = t.toCharArray();
                Arrays.sort(a);
                Arrays.sort(b);
                if(a.length != b.length) {
                    return false;
                }

                boolean equals = Arrays.equals(a, b);

                return equals;
            }
        }
}
