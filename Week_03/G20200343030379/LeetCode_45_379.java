package G20200343030379;

/**
 *  45. ��Ծ��Ϸ II
 *
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * ���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
 *
 * ʾ��:
 *
 * ����: [2,3,1,1,4]
 * ���: 2
 * ����: �������һ��λ�õ���С��Ծ���� 2��
 * ?    ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã���?1?����Ȼ����?3?��������������һ��λ�á�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/jump-game-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *  ������⣺(�����ȿ�˼·)
 *  https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
 *
 *
 */



public class LeetCode_45_379 {
    public static void main(String[] args) {
        new LeetCode_45_379().jump(new int[]{2,3,1,1,4,1});
    }

    /**
     * ̰���㷨
     *
     * ִ����ʱ : 2 ms , ������ Java �ύ�л����� 95.03% ���û�
     * �ڴ����� : 41 MB , ������ Java �ύ�л����� 5.04% ���û�
     * @return
     */
    public int jump(int[] nums) {
        //ǰһ�������Զ�ܵ����λ��
        int end=0;
        //��ǰ�����Զ�ܵ����λ��
        int maxPosition=0;
        //��Ծ����
        int setp=0;

        //nums.length-1 ���ڿ������һ�������ģ��������һ������Ҫ�жϣ�������ֶ�һ����������
        for (int i = 0; i < nums.length-1; i++) {
            maxPosition=Math.max(maxPosition,nums[i]+i);
            //���±߽�ֵ
            if(end==i){
                end=maxPosition;
                setp++;
            }
        }
        return setp;
    }

}
