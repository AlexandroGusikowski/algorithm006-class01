##字典树：
####基本概念：
```text字典树，trie树，又称单词树或者键树。典型的应用是用于统计和排序大量的字符串（但不限于字符串），所以经常被搜索引擎系统用于文本词频统计。``` 
  
####优点：
+ 1、最大限度的减少无谓的字符串比较。<br>
+ 2、查询效率比哈希表高。  
    
####基本性质：
+ 1、节点本身不存储完成单词。
+ 2、从根节点到某一节点，路径上经过的字符串连接起来，为该节点对应的字符串。
+ 3、每个节点的所有子节点路径代表的字符都不相同。
+ 4、节点可以存储额外信息，比如出现的频次。  

####核心思想：
+ 1、空间换时间。
+ 2、利用字符串的公共前缀来降低查询目的。时间的开销以达到提高效率。  

##并查集：
####解决的场景： 
+ 1、组团或者配对。
####基本操作：
+ 1、makeSet(s)：建立一个新的并查集，其中包含s个单元素集合。
+ 2、unionSet(x,y)：把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。
+ 3、find(x)：找到元素x所在集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的的代表比较一下即可。  


##高级搜索：
    相关:剪枝、双向BFS、启发式搜索
    
    初级搜索：
        1、朴素搜索
        2、优化方式：不重复，剪枝。
        3、搜索方向：DFS、BFS、双向BFS。  
        
####AVL树和红黑树的区别：
+ 1、AVL树提供了更快的查询操作。
+ 2、添加和删除操作红黑树更快。
+ 3、 AVL需要存储更多的信息（平衡因子和高度）占用额外空间比红黑树多，红黑树只需要一位来表示当前节点是红还是黑。
+ 4、 如果读操作多写操作少用AVL，如果插入或者更新操作多用红黑树。高级语言的库（Java Set Map）用的都是红黑树，database用的是AVL。