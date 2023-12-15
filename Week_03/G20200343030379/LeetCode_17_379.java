package G20200343030379;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *  17. �绰�������ĸ���
 *  ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
 *
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 *
 * ���룺"23"
 * �����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * �ο�������⣺https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8109/My-recursive-solution-using-Java
 */
public class LeetCode_17_379 {
    public static void main(String[] args) {
        List<String> strings = new LeetCode_17_379().letterCombinations("2");
        System.out.println(strings);
    }

    /***
     * ���η���
     * ִ����ʱ : 4 ms , ������ Java �ύ�л����� 10.34% ���û�
     * �ڴ����� : 38.1 MB , ������ Java �ύ�л����� 5.14% ���û�
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits==null || digits.length()==0 ){
            return list;
        }

        //��װMap�ĵ绰�ṹ
        Map map=new HashMap();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");


        //�ݹ�
        find(list,digits,0,"",map);

        return list;
    }

    private void find(List<String> list, String digits, int level, String str,Map map) {
        //������־
        if(level==digits.length()){
            list.add(str);
            return ;
        }

        //ִ���߼�
        //һ��������ڶ������Ҫѭ������
        char[] chars = ((String) map.get(digits.charAt(level)+"")).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //��һ��д������Ӻ��Լ�ɾ����β
            /*str+=(String.valueOf(chars[i]));
            find(list,digits,level+1,str,map);
            //ɾ����β����
            str=str.substring(0,str.length()-1);*/

            //�ڶ���д����ֻ������ʱ���������޸ı����ֵ���Ͳ�������β����
            find(list,digits,level+1,str+(String.valueOf(chars[i])),map);
            //ɾ����β����
            //str=str.substring(0,str.length()-1);
        }

    }
}
