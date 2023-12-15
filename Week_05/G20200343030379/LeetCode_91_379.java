package G20200343030379;
/**
 * 91. 解码方法
 *
 * 一条包含字母?A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释:?它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例?2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释:?它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LeetCode_91_379 {
    public static void main(String[] args) {
        new LeetCode_91_379().numDecodings2("100");
        //new LeetCode_91_379().numDecodings2("126");
    }
    //动态规划 从右到左
    /**
     * dp[i]=dp[i+1]+dp[i+2]
     *
     * 输入：1212
     * 2
     * 12
     * 212= 2 12
     * 1212=1 212、 12 12
     *
     * 0:不处理
     * <=26  dp[i]=dp[i+1]+dp[i+2]
     * >26  dp[i]=dp[i+1]
     *
     *
     * /**
     * 首先如果为7。很显然是1种7->G
     * 如果为67。很显然还是1种67->FG
     * 如果为067。结果为0。
     * 如果为2067。 结果为numDecodings（20 67）+ numDecodings（2 067）= numDecodings（20 67）->TFG
     * 如果为22067。 结果为numDecodings（2 2067）+ numDecodings（22 067）= numDecodings（2 2067）->BTFG
     *
     * 作者：reedfan
     * 链接：https://leetcode-cn.com/problems/decode-ways/solution/java-di-gui-dong-tai-gui-hua-kong-jian-ya-suo-by-r/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。//
     *
     *
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 38.1 MB , 在所有 Java 提交中击败了 5.01% 的用户
     *
     * 参考题解：https://leetcode-cn.com/problems/decode-ways/solution/java-di-gui-dong-tai-gui-hua-kong-jian-ya-suo-by-r/
     * https://leetcode.com/problems/decode-ways/discuss/30357/DP-Solution-(Java)-for-reference
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];

        //辅助数字
        dp[s.length()]=1;
        //初始最后的字符


        if(s.charAt(s.length()-1)=='0'){
            dp[s.length()-1]=0;
        }else{
            dp[s.length()-1]=1;
        }


        for (int i = s.length()-2; i >= 0; i--) {
            //问题场景 "00" ,输出0
            if(s.charAt(i)=='0'){
                dp[i]=0;
                continue;
            }

            //小于26
            if((s.charAt(i)-'0')*10+(s.charAt(i+1)-'0')<=26){
                dp[i]=dp[i+1]+dp[i+2];
            }else{
                dp[i]=dp[i+1];
                //System.out.println("==");
            }
        }
        return dp[0];
    }


    //动态规划 从左到右,两个题的思路是不同的
    /**
     * dp[i]=dp[i+1]+dp[i+2]
     *
     * 输入：1212
     * 2
     * 12
     * 212= 2 12  212
     * 1212=1 212、 12 12
     *
     * 0:不处理
     * <=26  dp[i]=dp[i+1]+dp[i+2]
     * >26  dp[i]=dp[i+1]
     *
     * 参考题解：https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation
     *
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 38.4 MB , 在所有 Java 提交中击败了 5.01% 的用户
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        int[] dp=new int[s.length()+1];

        //辅助数字
        dp[0]=1;
        //初始最后的字符


        //如果第一个0，非法
        if(s.charAt(0)=='0'){
            dp[1]=0;
        }else{
            dp[1]=1;
        }

        for (int i = 2; i <= s.length(); i++) {
           /* 没想到这段注释在leetcode会影响时间复杂度，这段注释到导致时间复杂度加1ms
            if(s.charAt(i-1)=='0'){
                dp[i]=dp[i-1];
                continue;
            }*/
            if(s.charAt(i-1)-'0'>=1 && (s.charAt(i-1)-'0')<=9){
                dp[i]=dp[i]+dp[i-1];
            }

            int send=(s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0');
            if(send>=10 && send<=26){
                dp[i]=dp[i]+dp[i-2];
            }

        }
        return dp[s.length()];
    }
}
