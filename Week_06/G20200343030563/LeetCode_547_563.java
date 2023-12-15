class Solution {
    public int findCircleNum(int[][] M) {
        UnioFind unioAarry = new UnioFind(M.length);

        for (int i = 0; i < M.length; i++)
            for(int j = i; j < M.length; j++){
                if (M[i][j] == 1 && i != j) {
                    unioAarry.union(i, j);
                }
            }

        return unioAarry.GetCount();
    }
}

class UnioFind{
    int[] parent;
    int[] size;
    int count;

    public UnioFind(int n){
        parent = new int[n];
        size = new int[n];

        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        count = n;
    }
    public int find(int p) {
        while(parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p ,int q){
        if (p == q) return;
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        //С���ӵ��������棬��ƽ��
        if (size[pRoot] > size[qRoot]) {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            parent[qRoot] = pRoot;
            size[qRoot] += pRoot;
        }

        count--;
    }
 

    public int GetCount(){
        return count;
    }
}