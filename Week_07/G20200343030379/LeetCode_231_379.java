package G20200343030379;

/**
 * 231. 2����
 *
 * ����һ����������дһ���������ж����Ƿ��� 2 ���ݴη���
 *
 * ʾ��?1:
 *
 * ����: 1
 * ���: true
 * ����: 20?= 1
 * ʾ�� 2:
 *
 * ����: 16
 * ���: true
 * ����: 24?= 16
 * ʾ�� 3:
 *
 * ����: 218
 * ���: false
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/power-of-two
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺
 */
public class LeetCode_231_379 {

    public static void main(String[] args) {
        //ʮ����ת������
        String s = Integer.toBinaryString(-2147483648);
        new LeetCode_231_379().isPowerOfTwo(-2147483648);
    }

    /**
     * x & x-1 �������λ������2���ݣ�ֻ�����λ1���Ϳ���֪���Ƿ��ݵ�ֵ
     *
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 100.00%���û�
     * �ڴ����� : 37 MB , ������ Java �ύ�л����� 5.50% ���û�
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        long x = (int)n;
        return x!=0 && (x & x-1)==0;
    }

    /**
     * x & (-x) �õ����λ��1:����ֻ�����λ��1�����Ի�ȡ��ߵ�ֵ�����˵�����ݵ�ֵ��
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 36.5 MB , ������ Java �ύ�л����� 5.50% ���û�
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        long x = (int)n;
        return x!=0 && (x & (-x))==x;
    }


}
