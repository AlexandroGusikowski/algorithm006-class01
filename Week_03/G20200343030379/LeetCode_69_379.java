package G20200343030379;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  69. x ��ƽ����
 *  ʵ��?int sqrt(int x)?������
 *
 * ���㲢����?x?��ƽ����������?x �ǷǸ�������
 *
 * ���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
 *
 * ʾ�� 1:
 *
 * ����: 4
 * ���: 2
 * ʾ�� 2:
 *
 * ����: 8
 * ���: 2
 * ˵��: 8 ��ƽ������ 2.82842...,
 * ?    ���ڷ���������������С�����ֽ�����ȥ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sqrtx
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺
 */
public class LeetCode_69_379 {
    public static void main(String[] args) {
    }

    /**
     * ���ֲ��ҷ�
     *
     * ִ����ʱ : 2 ms , ������ Java �ύ�л����� 79.94% ���û�
     * �ڴ����� : 36.9 MB , ������ Java �ύ�л����� 5.12% ���û�
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long left=0,right=x;
        long mid=0;

        while (left<=right){
            mid=(left+right)/2;
            if(mid*mid==x){
                return (int) mid;
            }else if(mid*mid>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return  (int) right;
    }

    /**
     * ţ�ٵ�����
     *
     * ִ����ʱ : 2 ms , ������ Java �ύ�л����� 79.94% ���û�
     * �ڴ����� : 36.7 MB , ������ Java �ύ�л����� 5.12% ���û�
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        long a=x;
        while (a*a>x){
            a = (a + x / a) / 2;
        }
        return (int) a;
    }


}
