package G20200343030379;

import java.awt.*;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU�������
 *
 * �����������յ����ݽṹ����ƺ�ʵ��һ��? LRU (�������ʹ��) ������ơ���Ӧ��֧�����²����� ��ȡ���� get �� д������ put ��
 *
 * ��ȡ���� get(key) - �����Կ (key) �����ڻ����У����ȡ��Կ��ֵ�����������������򷵻� -1��
 * д������ put(key, value) - �����Կ�����ڣ���д��������ֵ�������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ�����δʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣
 *
 * ����:
 *
 * ���Ƿ������?O(1) ʱ�临�Ӷ�����������ֲ�����
 *
 * ʾ��:
 *
 * LRUCache cache = new LRUCache( 2  ��������  );
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // ����  1
 * cache.put(3,3);    // �ò�����ʹ����Կ 2 ����
 * cache.get(2);       // ���� -1 (δ�ҵ�)
 * cache.put(4,4);    // �ò�����ʹ����Կ 1 ����
 * cache.get(1);       // ���� -1 (δ�ҵ�)
 * cache.get(3);       // ����  3
 * cache.get(4);       // ����  4
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/lru-cache
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺https://leetcode-cn.com/problems/lru-cache/solution/lru-huan-cun-ji-zhi-by-leetcode/
 */
public class LeetCode_146_379 {

    public static void main(String[] args) {
        //ʮ����ת������
        //String s = Integer.toBinaryString(-2147483648);
    }

    /**
     * ִ����ʱ : 19 ms , ������ Java �ύ�л����� 90.06% ���û�
     * �ڴ����� : 50.6 MB , ������ Java �ύ�л����� 89.88% ���û�
     */
    class LRUCache extends LinkedHashMap<Integer,Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity,0.75f,true);
            this.capacity=capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            super.put(key,value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size()>capacity;
        }
    }

    /**
     * ����������һ�ַ��������ϣ�ֻ��д����ͬ
     *
     * ִ����ʱ : 23 ms , ������ Java �ύ�л����� 62.61% ���û�
     * �ڴ����� : 50.7 MB , ������ Java �ύ�л����� 86.75% ���û�
     * ������⣻https://leetcode.com/problems/lru-cache/discuss/46055/Probably-the-%22best%22-Java-solution-extend-LinkedHashMap
     */
    class LRUCache3 {
        private int capacity;
        private Map<Integer,Integer> map;

        public LRUCache3(int capacity) {
            this.map=new  LinkedHashMap<Integer,Integer>(16,0.75f,true){
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size()>capacity;
                }
            };
            this.capacity=capacity;
        }

        public int get(int key) {
            return map.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            map.put(key,value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


    class DoubleList{
        private Node head,tail;
        private int size;

        DoubleList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
            size=0;
        }

        public void addFirst(Node x){
            x.next=head.next;
            x.prev=head;
            head.next.prev=x;
            head.next=x;
            size++;
        }

        public void remove(Node x){
            x.prev.next=x.next;
            x.next.prev=x.prev;
            size--;
        }

        public Node removeLast(){
            if(tail.prev==head) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int getSize() {
            return size;
        }
}

    class Node {
        public  int key,val;
        public Node next,prev;

        Node(int k ,int v){
            this.key=k;
            this.val=v;
        }

    }

    /**
     * ���������Լ���һ��hashmap��˫������
     * ִ����ʱ : 21 ms , ������ Java �ύ�л����� 71.79% ���û�
     * �ڴ����� : 53.3 MB , ������ Java �ύ�л����� 71.50% ���û�
     */
    class LRUCache2{
        private HashMap<Integer,Node> map;
        private DoubleList cache;
        private int cap;

        LRUCache2(int capacity){
            this.cap=capacity;
            cache=new DoubleList();
            map=new HashMap<>();
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                this.put(node.key,node.val);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node=new Node(key,value);
            if(map.containsKey(key)){

                cache.remove(map.get(key));
            }else{
                if(cap==cache.getSize()){
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
            }
            cache.addFirst(node);
            map.put(key,node);
        }
    }
}
