/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

// @lc code=start
// @date Mar 28 2020
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0  && (n & (n - 1)) == 0;
    }
}
// @lc code=end

