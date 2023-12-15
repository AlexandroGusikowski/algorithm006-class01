package G20200343030379;

import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *  433. ��С����仯
 *  һ������������һ������8���ַ����ַ�����ʾ������ÿ���ַ������� "A", "C", "G", "T"�е�����һ����
 *
 * ��������Ҫ����һ���������еı仯��һ�λ���仯��ζ��������������е�һ���ַ������˱仯��
 *
 * ���磬����������"AACCGGTT"?�仯��?"AACCGGTA"?��������һ�λ���仯��
 *
 * ���ͬʱ��ÿһ�λ���仯�Ľ��������Ҫ��һ���Ϸ��Ļ��򴮣����ý������һ������⡣
 *
 * ���ڸ���3������ �� start, end, bank���ֱ������ʼ�������У�Ŀ��������м�����⣬���ҳ��ܹ�ʹ��ʼ�������б仯ΪĿ�����������������ٱ仯����������޷�ʵ��Ŀ��仯���뷵�� -1��
 *
 * ע��:
 *
 * ��ʼ��������Ĭ���ǺϷ��ģ�����������һ��������ڻ�����С�
 * ���е�Ŀ��������б����ǺϷ��ġ�
 * �ٶ���ʼ����������Ŀ����������ǲ�һ���ġ�
 * ʾ�� 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 *
 * ����ֵ: 1
 * ʾ�� 2:
 *
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * ����ֵ: 2
 * ʾ�� 3:
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * ����ֵ: 3
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-genetic-mutation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο���⣺https://leetcode-cn.com/problems/minimum-genetic-mutation/solution/java-dfs-hui-su-by-1yx/
 */
public class LeetCode_433_379 {
    public static void main(String[] args) {
        int i = new LeetCode_433_379().minMutation_2("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
        System.out.println(i);


    }

    /**
     * ���б�����-->����������� BFS
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 75.78% ���û�
     * �ڴ����� : 36.9 MB , ������ Java �ύ�л����� 5.13% ���û�
     */
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 1;

        //��ʼ�����ϡ�����
        Set bankSet=new HashSet();
        char[] charSet=new char[]{'A','C','G','T'};
        Queue<String> queue=new LinkedList<>();
        Set visited=new HashSet();


        //��ʼ������
        int lever=0;
        queue.add(start);
        visited.add(start);

        for (String b : bank) {
            bankSet.add(b);
        }

        //��������
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- >0){
                String poll = queue.poll();
                if(poll.equals(end)){
                    return lever;
                }

                //����ÿ���ַ�
                char[] chars = poll.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old=chars[i];

                    for (char c : charSet) {
                        //����µ��ַ���
                        chars[i]=c;

                        String next=new String(chars);

                        //�ж��Ƿ�����bank,�����Ƿ��ʹ���
                        if(!visited.contains(next) && bankSet.contains(next)){
                            //��ӵ�����
                            queue.add(next);
                            visited.add(next);
                        }

                    }

                    chars[i]=old;
                }


            }
            lever++;
        }
        return -1;

    }

    /**
     * ���б�����-->����������� BFS���Ա�minMutation()�����д�������Ż�
     *
     * ִ����ʱ : 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 37.6 MB , ������ Java �ύ�л����� 5.13% ���û�
     */
    public int minMutation_2(String start, String end, String[] bank) {
        if(start.equals(end)) return 1;

        //��ʼ�����ϡ�����
        Queue<String> queue=new LinkedList<>();
        Set visited=new HashSet();


        //��ʼ������
        int lever=0;
        queue.add(start);
        visited.add(start);

        //��������
        while (!queue.isEmpty()){
            int size = queue.size();
            //����ÿһ�㣬ÿ�� level+1
            while (size-- >0){
                String poll = queue.poll();
                if(poll.equals(end)){
                    return lever;
                }

                //����ÿ���ַ�
                char[] chars = poll.toCharArray();
                for (String b : bank) {
                    if(visited.contains(b)){
                        continue;
                    }
                    int diff=0;
                    for (int i = 0; i < chars.length; i++) {
                        if(chars[i]!=b.charAt(i)){
                            if(++diff>1){
                                break;
                            }
                        }
                    }

                    //����Ƿ����ڻ����
                    if(diff==1){
                        queue.add(b);
                        visited.add(b);
                    }

                }
            }
            lever++;
        }
        return -1;

    }

    /**
     * �ݹ鷨-->����������� DFS����������ʹ��������ȣ����bank�ܶ࣬�ǳ�ʱ�Ǳ�Ȼ�ģ�
     * �ο���⣺https://leetcode-cn.com/problems/minimum-genetic-mutation/solution/java-dfs-hui-su-by-1yx/
     */
    int minStepCount=Integer.MAX_VALUE;
    public int minMutation2(String start, String end, String[] bank) {
        //�Ƿ����ж�
        if(start.equals(end)) return 1;
        if(bank==null || bank.length==0) return -1;
        dfs(new HashSet<String>(),0,start,end,bank);
        return (minStepCount==Integer.MAX_VALUE)?-1:minStepCount;
    }

    /**
     *
     * @param visited ���������ַ�
     * @param stepCount �߹��Ĵ���
     * @param currentStr ��ǰ������ַ�
     * @param end  Ŀ���ַ�
     * @param bank �����
     */
    public void dfs(Set<String> visited,int stepCount,String currentStr,String end,
                    String[] bank){
        if(currentStr.equals(end)){
            minStepCount=Math.min(minStepCount,stepCount);
            return;
        }

        //ɨ�����⣬����ֵΪ1�Ļ���
        for (String str : bank) {
            int diff=0;//�����ַ����Ա������м�����ͬ
            for (int i = 0; i < currentStr.length(); i++) {
                if(currentStr.charAt(i)!=str.charAt(i)){
                    //����1�����ϼ��˳�,û��Ҫ�����ж�
                    if(++diff >1) {
                        break;
                    }
                }
            }

            //����Ƿ������,��ֵ����Ϊ1
            if(diff==1 && !visited.contains(str) ){
                visited.add(str);
                //�ݹ�
                dfs(visited,stepCount+1,str,end,bank);
                //visited.remove(str);
            }

        }
    }


}
