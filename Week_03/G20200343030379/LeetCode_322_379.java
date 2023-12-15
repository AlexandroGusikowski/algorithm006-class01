package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  322. ��Ǯ�һ�
 *
 *  ������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ�����?-1��
 *
 * ʾ��?1:
 *
 * ����: coins = [1, 2, 5], amount = 11
 * ���: 3
 * ����: 11 = 5 + 5 + 1
 * ʾ�� 2:
 *
 * ����: coins = [2], amount = 3
 * ���: -1
 * ˵��:
 * �������Ϊÿ��Ӳ�ҵ����������޵ġ�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/coin-change
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *  ������⣺
 */



public class LeetCode_322_379 {
    public static void main(String[] args) {
        new LeetCode_322_379().coinChange(new int[]{186,419,83,408},6249);
    }

    /**
     * ̰���㷨������
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count=0;
        if(amount==0) return 0;

        for (int i = coins.length-1; i >= 0; i--) {
            int chu=amount/coins[i];
            count+=chu;
            if(chu==0) continue;
            //��������
            amount=amount-(chu*coins[i]);

            if(amount==0){
                return count;
            }
        }


        return -1;

    }

}
