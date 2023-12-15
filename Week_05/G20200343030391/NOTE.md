# 动态规划
## 关键点
    - 动态规划和递归或者分治没有根本上的区别（关键看有无最优子结构）
    - 共性：找到重复子问题
    - 差异性：最优子结构，中途可以淘汰次优解（反悔）
    - 状态转移方程（DP方程）
## 解题步骤
    - 最优子结构 opt[n]=best_of(opt[n-1],opt[n-2])
    - 存储中间状态 opt[i]
    - 递推公式（状态转移方程 or DP方程）
        - fib:opt[n]=best_of(opt[n-1],opt[n-2])
        - 二维路径：opt[i,j]= opt[i+1,j]+opt[i,j+1]
## 总结
    - 打破思维惯性，形成及其思维，找重复性
    - 理解复杂逻辑的关键