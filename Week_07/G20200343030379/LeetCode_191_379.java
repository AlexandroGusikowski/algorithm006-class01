package G20200343030379;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 191. λ1�ĸ���
 *
 * ��дһ��������������һ���޷�������������������Ʊ��ʽ������λ��Ϊ ��1��?�ĸ�����Ҳ����Ϊ������������
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺00000000000000000000000000001011
 * �����3
 * ���ͣ�����Ķ����ƴ� 00000000000000000000000000001011?�У�������λΪ '1'��
 * ʾ�� 2��
 *
 * ���룺00000000000000000000000010000000
 * �����1
 * ���ͣ�����Ķ����ƴ� 00000000000000000000000010000000?�У�����һλΪ '1'��
 * ʾ�� 3��
 *
 * ���룺11111111111111111111111111111101
 * �����31
 * ���ͣ�����Ķ����ƴ� 11111111111111111111111111111101 �У����� 31 λΪ '1'��
 * ?
 *
 * ��ʾ��
 *
 * ��ע�⣬��ĳЩ���ԣ��� Java���У�û���޷����������͡�����������£���������������ָ��Ϊ�з����������ͣ����Ҳ�ӦӰ������ʵ�֣���Ϊ�����������з��ŵĻ����޷��ŵģ����ڲ��Ķ����Ʊ�ʾ��ʽ������ͬ�ġ�
 * �� Java �У�������ʹ�ö����Ʋ���Ƿ�����ʾ�з�����������ˣ��������?ʾ�� 3?�У������ʾ�з������� -3��
 * ?
 *
 * ����:
 * �����ε�������������㽫����Ż�����㷨��
 *
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-1-bits
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * //�ⷨ��
 *      0����������ת�����ƣ���������
 *      1�����뷨
 *      2��&1 �� x = x >> 1 ; (32)
 *      3��while��x > 0 �� {count ++; x = x & (x - 1)}
 *
 * �ο�������⣺
 * https://leetcode-cn.com/problems/number-of-1-bits/solution/man-hua-gan-jiu-dui-liao-ao-li-gei-by-ivan1-2/
 */
public class LeetCode_191_379 {

    public static void main(String[] args) {
        //ʮ����ת������
        String s = Integer.toBinaryString(-3);
        new LeetCode_191_379().hammingWeight3(-3);
    }


    // you need to treat n as an unsigned value

    /**
     * ������
     * ִ����ʱ : 2 ms , ������ Java �ύ�л����� 7.84% ���û�
     * �ڴ����� : 36.3 MB , ������ Java �ύ�л����� 5.58% ���û�
     * @param n
     * @return
     */
    public int hammingWeight0(int n) {
        String s = Integer.toBinaryString(n);
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }


    /**
     * %2 == 1, /2
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 99.75% ���û�
     * �ڴ����� : 36.5 MB , ������ Java �ύ�л����� 5.45% ���û�
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count=0;
        for (int i = 0; i < 32; i++) {
            if((n&1)==1){
                count++;
            }
            //�����Ķ����ƶ��Ƿ��룬Ҳ���Ǵ󲿷ֶ���1��������while(n!=0) �ж�
            n = n >> 1;
            System.out.println(n);
        }
        return count;
    }

    /**
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 99.75% ���û�
     * �ڴ����� : 36.4 MB , ������ Java �ύ�л����� 5.58% ���û�
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count=0;
        int mask=1;
        for (int i = 0; i < 32; i++) {
            if((n&mask)!=0){ //�ǱȽ�ʮ���ƣ����Ƕ�����
                count++;
            }
            //��mask��1����һλ
            mask = mask << 1;
            //System.out.println(n);
        }
        return count;
    }

    /**
     * while��x > 0 �� {count ++; x = x & (x - 1)}
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 99.75% ���û�
     * �ڴ����� : 36.4 MB , ������ Java �ύ�л����� 5.45% ���û�
     * @param n
     * @return
     */
    public int hammingWeight3(int n) {
        int count=0;
        //���ڸ������������Ҫ�ж�
        while(n!=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }


}
