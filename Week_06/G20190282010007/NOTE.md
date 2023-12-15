学习笔记

并查集
1、 适用场景
组团、配对问题
group or not？
2、 基本操作
makeSet(s): 建立一个新的并查集，其中包含s个单元素集合
unionSet(x, y): 把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并
find(x): 找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将他们各自的代表比较一下就可以了

并查集的js代码模板
    let makeSet = (x) => { parent[x] = x}
    let find = (x) => {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]
            x = parent[x]
        }
        return x
    }
    let union = (x, y) => {
        let rootX = find(x), rootY = find(y)
        if (rootX == rootY) return
        parent[rootX] = rootY 
    }

字典树
1、 字典树的数据结构
即Trie树，又称单词查找树或键树，是一种属性结构，典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎用于文本词频统计
优点是：最大限度的减少无谓的字符串比较，查询效率比哈希表高
2、 字典树的核心思想
空间换时间
利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的
3、 字典树的基本性质
a、节点本身不存完整单词；
b、从根节点到某一节点，路径上经过的字符链接起来，为该节点对应的字符串
c、每个节点的所有子节点路径代表的字符都不相同


关于单词搜索2的时间复杂度分析，构造字典的时候，需要循环words，words中的每个单词也要将字母抽取出来
所以第一步构造字典树已有O(n*n)
然后dfs中，4向查找，每个board的元素查找4次，这里又有，O(4*n) = O(n)
循环遍历board中的没个元素拿去dfs，由于题目中的board是二维数组，那么两层循环下来，是O(n*n)
所以单词搜索2的总时间复杂度为：O(n*n) + O(n) + O(n*n) = O(n*n)

高级搜索很懵逼，AVL树（自平衡树）和红黑树（自平衡二叉搜索树）也是很懵逼，多方面查资料与反复过遍数中