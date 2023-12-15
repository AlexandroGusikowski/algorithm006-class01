package G20200343030379;

import java.util.TreeMap;

/**
 * 1122. ������������
 *
 * �����������飬arr1 ��?arr2��
 *
 * arr2?�е�Ԫ�ظ�����ͬ
 * arr2 �е�ÿ��Ԫ�ض�������?arr1?��
 * �� arr1?�е�Ԫ�ؽ�������ʹ arr1 ��������˳���?arr2?�е����˳����ͬ��δ��?arr2?�г��ֹ���Ԫ����Ҫ�����������?arr1?��ĩβ��
 *
 * ?
 *
 * ʾ����
 *
 * ���룺arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * �����[2,2,2,1,4,3,3,9,6,7,19]
 * ?
 *
 * ��ʾ��
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2?�е�Ԫ��?arr2[i]?������ͬ
 * arr2 �е�ÿ��Ԫ��?arr2[i]?��������?arr1?��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/relative-sort-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺
 */
public class LeetCode_1122_379 {

    public static void main(String[] args) {
        //ʮ����ת������
        //String s = Integer.toBinaryString(-2147483648);
    }

    /**
     * ��벿�������ü������򣬼�������index��Ϊ��������
     *
     * ִ����ʱ : 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 38.4 MB , ������ Java �ύ�л����� 5.40% ���û�
     *
     * ������⣺https://leetcode.com/problems/relative-sort-array/discuss/335056/Java-in-place-solution-using-counting-sort
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int cnt[]=new int[1001];
        for (int n : arr1) {
               cnt[n]++;
        }

        int count=0;
        for (int n : arr2) {
            while (cnt[n]-->0){
                arr1[count++]=n;
            }
        }

        //����ʣ��û�г�����arr2����
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i]-->0){
                arr1[count++]=i;
            }
        }
        return arr1;
    }


}
