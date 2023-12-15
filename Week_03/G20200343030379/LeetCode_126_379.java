package G20200343030379;





import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *  126. ���ʽ��� II
 *  �����������ʣ�beginWord �� endWord����һ���ֵ� wordList���ҳ����д� beginWord �� endWord �����ת�����С�ת������ѭ���¹���
 *
 * ÿ��ת��ֻ�ܸı�һ����ĸ��
 * ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
 * ˵��:
 *
 * ���������������ת�����У�����һ�����б�
 * ���е��ʾ�����ͬ�ĳ��ȡ�
 * ���е���ֻ��Сд��ĸ��ɡ�
 * �ֵ��в������ظ��ĵ��ʡ�
 * ����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
 * ʾ�� 1:
 *
 * ����:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * ���:
 * [
 *   ["hit","hot","dot","dog","cog"],
 * ? ["hit","hot","lot","log","cog"]
 * ]
 * ʾ�� 2:
 *
 * ����:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * ���: []
 *
 * ����:?endWord "cog" �����ֵ��У����Բ����ڷ���Ҫ���ת�����С�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/word-ladder-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *  ������⣨��ȫ�����ֵ����Ż��㷨����
 *  https://leetcode.com/problems/word-ladder-ii/discuss/40477/Super-fast-Java-solution-(two-end-BFS)
 *
 *  ����������
 *  https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS
 *  https://leetcode-cn.com/problems/word-ladder-ii/solution/bfs-dfs-by-powcai/
 */



public class LeetCode_126_379 {
    /***
     * ע�⣬��ʵ����������Ϊһ����
     *      1����while (size-- >0){��ÿ����һ�ζ��У�����һ�㣬
     *      2�� ÿ�������ܰ�������ӽ�㣬���ܰ������·����ֻȡ���·�������Ա����� wordlist�����ﲻ����arraylist��ֻ����hashSet���Ƶģ������Ǳ���ƥ�䣩.contains����ƥ��
     * @param args
     */
    public static void main(String[] args) {
        /**
         * "hit"
         * "cog"
         * ["hot","dot","dog","lot","log","cog"]
         */
        new LeetCode_126_379().findLadders("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog"));
    }

    /**
     *
     nodeNeighborsÿ����������ƥ���ǵ��� {lot=[dot, log, hot], hit=[hot], log=[cog, dog, lot], dot=[dog, hot, lot], cog=[], hot=[dot, hit, lot], dog=[cog, log, dot]}
     dict������ [lot, hit, log, dot, cog, hot, dog]
     distance���·��  {lot=2, hit=0, log=3, dot=2, cog=4, hot=1, dog=3}
     Ԥ�ڽ��
     [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
     * @param start
     * @param end
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        //���·��
        Map<String,Integer> distance=new HashMap<>();
        //����set����
        Set<String> dict=new HashSet<>(wordList);
        //�ٽ�ֵ
        Map<String,List<String>> nodeNeighbors=new HashMap<>();
        //ÿһ�������ֵ
        List<String> solution=new ArrayList<>();
        //����ֵ
        List<List<String>> res=new ArrayList<>();
        //�ѵ�һ�������ӽ�ȥ���·��,��Ϊ����
        distance.put(start,0);
        dict.add(start);


        bfs(start,end,dict,nodeNeighbors,distance);
        dfs(start,end,nodeNeighbors,distance,res,solution);

        return res;
    }

    private void bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
        //��ʼ��ÿ�����ʵ��ٽ�ֵ
        for (String str : dict) {
            nodeNeighbors.put(str,new ArrayList<>());
        }
        Queue<String> queue=new LinkedList();
        queue.offer(start);

        while (!queue.isEmpty()){
            int size = queue.size();
            //�Ƿ��ҵ���β���
            boolean foundEnd=false;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                //��ǰ���·��
                int curDistance = distance.get(cur);

                //��ȡÿ���ٽ�ֵ
                List<String> neighbors = getNeighbors(cur, dict);
                for (String neighbor : neighbors) {
                    //��ӵ��ٽ���
                    nodeNeighbors.get(cur).add(neighbor);

                    //����Ƿ������
                    if(!distance.containsKey(neighbor)){
                        //�������·��
                        distance.put(neighbor,curDistance+1);

                        //����Ƿ�END����ֵ
                        if(neighbor.equals(end)){
                            foundEnd=true;
                        }else{
                            //��������ֵ����������
                            queue.offer(neighbor);
                        }

                    }
                }


            }

            //�ҵ���β��������ٲ���
            if(foundEnd){
                break;
            }
        }

    }

    private void dfs(String cur, String end, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance,List<List<String>> res, List<String> solution) {
        //���ÿ��Ԫ��
        solution.add(cur);

        //����ֵ׷�ӵ���β
        if(cur.equals(end)){
            res.add(new ArrayList<>(solution));
            //ע�ⲻҪreturn�����º��治�ܳ���ѡ�񣬵��»���
        }else{
            //������ǰ�ٽ�ֵ
            for (String neighbor : nodeNeighbors.get(cur)) {
                //�������·�����ж��Ƿ�����ݹ����Ҫ�������ϲ����·���Ƚϵ�ǰ���·��������Ҫ��1
                if(distance.get(neighbor)==distance.get(cur)+1){
                    dfs(neighbor,end,nodeNeighbors,distance,res,solution);
                }
            }
        }


        //����ѡ��
        solution.remove(solution.size()-1);
    }


    /**
     * ����ǰ�ַ��������ַ�
     * @param node ��ʼ����
     * @param dict �����б�
     * @return
     */
    private List<String> getNeighbors(String node, Set<String> dict) {
        List<String> res=new ArrayList<>();
        char[] chars = node.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old=chars[i];
            for(char c='a';c<='z';c++){
                chars[i]=c;
                String next = new String(chars);
                if(dict.contains(next)){
                    res.add(next);
                }
            }
            chars[i]=old;
        }
        return res;
    }



}
