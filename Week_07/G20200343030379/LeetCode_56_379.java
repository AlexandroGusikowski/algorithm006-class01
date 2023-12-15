package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. �ϲ�����
 *
 * ����һ������ļ��ϣ���ϲ������ص������䡣
 *
 * ʾ�� 1:
 *
 * ����: [[1,3],[2,6],[8,10],[15,18]]
 * ���: [[1,6],[8,10],[15,18]]
 * ����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
 * ʾ��?2:
 *
 * ����: [[1,4],[4,5]]
 * ���: [[1,5]]
 * ����: ���� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-intervals
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺
 */
public class LeetCode_56_379 {

    public static void main(String[] args) {
        //ʮ����ת������
        //String s = Integer.toBinaryString(-2147483648);
    }

    /**
     * 1���п�
     *
     * 2������
     *
     * 3����ȡ���ұ߽�
     *
     * 4����������
     * 	4.1 ��һ����߽�С�ڵ��ڵ�ǰ�ұ߽�
     * 		4.1.1 ��һ���ұ߽� ���ڵ�ǰ��߽�
     * 			�����б߽�
     *
     * 	4.2 ��һ���ұ߽���ڵ�ǰ�ұ߽�
     * 		4.2.1 ��ӵ�ǰ���ұ߽�
     * 			������һ�����ұ߽�
     *  5 ��¼���ұ߽�ֵ
     *
     *
     *  ִ����ʱ : 7 ms , ������ Java �ύ�л����� 86.96% ���û�
     *  �ڴ����� : 41.7 MB , ������ Java �ύ�л����� 54.96% ���û�
     *
     *  ������⣺
     *      https://leetcode-cn.com/problems/merge-intervals/solution/pai-xu-yi-ci-sao-miao-zhu-xing-jie-shi-hao-li-jie-/
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> res=new ArrayList<>();
        if(intervals.length==0) return res.toArray(new int[intervals.length][]);

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        int length=intervals.length;
        int left=intervals[0][0];
        int right=intervals[0][1];

        for (int i = 1; i < length-1; i++) {
            if(intervals[i][0]<=right){
                if(intervals[i][1]>right){
                    right=intervals[i][1];
                }
            }else{
                res.add(new int[]{left,right});
                left=intervals[i][0];
                right=intervals[i][1];
            }

        }
        res.add(new int[]{left,right});

        return res.toArray(new int[res.size()][]);
    }
}