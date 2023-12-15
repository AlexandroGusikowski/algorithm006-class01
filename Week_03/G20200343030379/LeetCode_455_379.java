package G20200343030379;

import java.util.Arrays;

/**
 *  455. �ַ�����
 *
 *  ��������һλ�ܰ��ļҳ�����Ҫ����ĺ�����һЩС���ɡ����ǣ�ÿ���������ֻ�ܸ�һ����ɡ���ÿ������ i ������һ��θ��ֵ?gi ���������ú���������θ�ڵı��ɵ���С�ߴ磻����ÿ����� j ������һ���ߴ� sj?����� sj >= gi?�����ǿ��Խ�������� j ��������� i ��������ӻ�õ����㡣���Ŀ���Ǿ���������Խ�������ĺ��ӣ��������������ֵ��
 *
 * ע�⣺
 *
 * ����Լ���θ��ֵΪ����
 * һ��С�������ֻ��ӵ��һ����ɡ�
 *
 * ʾ��?1:
 *
 * ����: [1,2,3], [1,1]
 *
 * ���: 1
 *
 * ����:
 * �����������Ӻ�����С���ɣ�3�����ӵ�θ��ֵ�ֱ��ǣ�1,2,3��
 * ��Ȼ��������С���ɣ��������ǵĳߴ綼��1����ֻ����θ��ֵ��1�ĺ������㡣
 * ������Ӧ�����1��
 * ʾ��?2:
 *
 * ����: [1,2], [1,2,3]
 *
 * ���: 2
 *
 * ����:
 * �����������Ӻ�����С���ɣ�2�����ӵ�θ��ֵ�ֱ���1,2��
 * ��ӵ�еı��������ͳߴ綼���������к������㡣
 * ������Ӧ�����2.
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/assign-cookies
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *  ������⣺
 *  https://leetcode-cn.com/problems/assign-cookies/solution/tan-xin-suan-fa-fen-fa-bing-gan-by-humbert/
 *  https://leetcode-cn.com/problems/assign-cookies/solution/you-xian-man-zu-wei-kou-xiao-de-xiao-peng-you-de-x/
 */



public class LeetCode_455_379 {

    /**
     * ̰���㷨
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        //ȫ����С������
        Arrays.sort(g);
        Arrays.sort(s);

        int i =0;
        int j=0;
        int count=0;
        while (i<g.length && j<s.length){
            if(s[j]>=g[i]){
                i++;j++;
                count++;
            }else{
                j++;
            }
        }
        return count;
    }

}
