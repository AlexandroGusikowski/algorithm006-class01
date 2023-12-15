package G20200343030379;

import java.util.List;

/**
 * 367. ��Ч����ȫƽ����
 *
 * ����һ�������� num����дһ����������� num ��һ����ȫƽ�������򷵻� True�����򷵻� False��
 *
 * ˵������Ҫʹ���κ����õĿ⺯������? sqrt��
 *
 * ʾ�� 1��
 *
 * ���룺16
 * �����True
 * ʾ�� 2��
 *
 * ���룺14
 * �����False
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/valid-perfect-square
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *
 * �ο�������⣺
 */
public class LeetCode_367_379 {
    public static void main(String[] args) {
    }

    /**
     * ���ֲ��ҷ�
     *
     * ִ����ʱ : 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 36.3 MB , ������ Java �ύ�л����� 5.01% ���û�
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        //Ϊ�˼򻯲���Ҫ�Ĳ�ѯ��right=num/2;
        long left=2,right=num/2;
        long mid=0;
        while (left<=right){
            mid=(left+right)/2;

            if(mid*mid==num){
                return true;
            }else if(mid*mid>num){
                right=mid-1;
            }else{
                left=mid+1;
            }

        }
        return right*right==num;
        //return false Ҳ��û�������
        //return false;
    }


    /**
     * ţ�ٵ�����
     *
     *  ִ����ʱ : 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     *  �ڴ����� : 36.1 MB , ������ Java �ύ�л����� 5.01% ���û�z
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        if(num==1)return true;

        long x=num;
        while (x*x>num){
            x=(x + num / x) / 2;
        }
        return x*x==num;
    }


}
