#### Hash Table
- 哈希表，也叫散列表，是根据关键码值而直接进行访问的数据结构。它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。这个映射函数叫做散列函数(Hash Function)，存放记录的数组叫做哈希表。
- 时间复杂度
  1. 查找：O(1)
  2. 新增：O(1)
  3. 删除：O(1)
  4. 当哈希碰撞很多，或者哈希表的size太小，就会导致链表链的太长，导致查找、新增、删除的都是O(1)

#### 树
- 相关概念
  1. 根节点
  2. 父节点
  3. 子节点
  4. 兄弟节点
  5. 层级，一层、两层、三层
- 数组遍历
  1. 前序(Pre-order)：根-左-右
  2. 中序(In-order)：左-根-右
  3. 后序(Post-order)：左-右-根
- 二叉搜索树
  - 也称二叉搜索排序树，有序二叉树、排序二叉树。是指一颗空树或者具有如下性质的二叉树
  - 特性
    1. 左子树上所有节点的值均小于它的根节点的值
    2. 右子树上所有节点的值均大于它的根节点的值
    3. 以此类推：左、右子树也分别为二叉查找树。（这是重复性）
  - 时间复杂度
    1. 查找：O(logn)
    2. 新增：O(logn)
    3. 删除：O(logn)

#### 递归
- 递归-循环，通过函数体来进行的循环
- 递归代码模板
  1. 递归终结条件
  2. 处理当前层的逻辑
  3. 下探到下一层
  4. 清理当前层