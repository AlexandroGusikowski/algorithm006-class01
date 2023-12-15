package G20200343030379;

/**
 * 190. �ߵ�������λ
 *
 * �ߵ������� 32 λ�޷��������Ķ�����λ��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ����: 00000010100101000001111010011100
 * ���: 00111001011110000010100101000000
 * ����: ����Ķ����ƴ� 00000010100101000001111010011100 ��ʾ�޷������� 43261596��
 *       ��˷��� 964176192��������Ʊ�ʾ��ʽΪ 00111001011110000010100101000000��
 * ʾ�� 2��
 *
 * ���룺11111111111111111111111111111101
 * �����10111111111111111111111111111111
 * ���ͣ�����Ķ����ƴ� 11111111111111111111111111111101 ��ʾ�޷������� 4294967293��
 * ?     ��˷��� 3221225471 ������Ʊ�ʾ��ʽΪ 10101111110010110010011101101001��
 * ?
 *
 * ��ʾ��
 *
 * ��ע�⣬��ĳЩ���ԣ��� Java���У�û���޷����������͡�����������£���������������ָ��Ϊ�з����������ͣ����Ҳ�ӦӰ������ʵ�֣���Ϊ�����������з��ŵĻ����޷��ŵģ����ڲ��Ķ����Ʊ�ʾ��ʽ������ͬ�ġ�
 * �� Java �У�������ʹ�ö����Ʋ���Ƿ�����ʾ�з�����������ˣ��������?ʾ�� 2?�У������ʾ�з������� -3�������ʾ�з������� -1073741825��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-bits
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺
 */
public class LeetCode_190_379 {

    public static void main(String[] args) {
        //ʮ����ת������
        //String s = Integer.toBinaryString(-2147483648);
        new LeetCode_190_379().reverseBits(43261596);
    }

    /**
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 37.9 MB , ������ Java �ύ�л����� 5.27% ���û�
     * ������⣺https://leetcode-cn.com/problems/reverse-bits/solution/js-ban-shao-shao-xiu-gai-ji-ke-by-kimigao/
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans=0;
        for (int i = 0; i < 32; i++) {
           // System.out.print("ans<<1===="+Integer.toBinaryString(ans<<1)+"   ======ans   ");
            ans= (ans<<1) + (n&1);
          //  System.out.println(Integer.toBinaryString(ans)+"   ======n&1    "+Integer.toBinaryString(n&1)+"   ======n    "+Integer.toBinaryString(n));
            n = n >>1;
        }
        //�޷������ƣ�������߲�0��������߲�0
        return ans >>>0;

    }

    /**
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 37.7 MB , ������ Java �ύ�л����� 5.27% ���û�
     * ������⣺https://leetcode-cn.com/problems/reverse-bits/solution/shu-xue-si-xiang-by-lo_e-2/
     * @param n
     * @return
     */
    public int reverseBits2(int n) {
        int reverse=0;
        int i=0;
        while(i<=31){
            reverse = reverse<<1;
            reverse |= (n & 1);
            n = n >> 1;
            i++;
        }
        return reverse;
    }


}
