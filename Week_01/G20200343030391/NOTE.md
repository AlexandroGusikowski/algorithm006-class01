# 学习笔记

## 1.数组
   ### 概念
   - 数组是一种线性表的数据结构，用一组连续的内存空间存储相同类型的数据
   - 线性表：每个数据最多只有一个前驱和后继节点如数组、链表、队列、栈
   - 非线性表：树、图、堆
   - 连续的内存空间和相同的数据类型保证了可以实现随机访问
   ### 操作
   - 随机访问：时间复杂度O(1)
   - 插入：尾部插入O(1)；随机插入O(n)
   - 删除：删除最后一个O(1)；随机删除O(n)

## 2. 链表
   ### 概念
   - 链表是一种物理存储单元谁给你非连续、非顺序的存储结构，数据元素的逻辑顺序通过链表中的指针实现  
   - 循环链表：尾结点只想头结点，可以是单链表也可以是双链表
   - 单向链表：值、指针；插入删除：O(1)；随机访问：O(n)
   - 双向链表: 值、prev、next;头部、尾部、给定节点操作O(1)
   - 静态链表: 值、指针、下标；用数组描述链表
   ### 操作
   - 随机访问：O(n)
   - 插入：随机插入O(n)
   - 删除：随机删除O(n)

## 3.跳表
   ### 概念
   - 在有序的链表的基础上，通过维护对层次的索引链加快查询、插入、删除速度
   ### 操作
   - 查询：O(log(n))
   - 插入：O(log(n))
   - 删除：O(log(n))
## 4.栈
   ### 概念
   - 栈是一种操作受限的线性表，体现在只能在一端插入删除数据，先进后出 FILO
   - 数组实现：顺序栈；链表实现：链式栈
   ### 操作
   - 入栈push：栈顶压入O(1)
   - 出栈pop：栈顶取出O(1)
   - 访问栈顶：peekO(1)
## 5.队列
   ### 概念
   - 队列是一种操作受限的线性表，先进先出FILO
   - head指针+tail指针
   - 顺序队列：isFull = tail==capacity；isEmpty = head==tail;
   - 双端对垒：同时具有队列和栈的特性，支持从两端添加、取出元素
   ### 操作
   - 入队：队尾加入O(1)
   - 出队：队首取出O(1)
## 6.优先队列
   ### 概念
   - 使用堆实现，元素具有优先级，入队最大（最小）优先级加入堆顶，出队最大（最小）优先级弹出
   ### 操作
   - 入队：堆实现log(n)
   - 出队：堆实现log(n)
   

## 算法套路
   - 五毒神掌
   - 升维思想
   - 空间换时间
   - 阅读代码添加注释
   - 变量命名辅助理解 