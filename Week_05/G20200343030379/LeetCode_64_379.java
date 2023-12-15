package G20200343030379;
/**
 * 64. ��С·����
 *
 * ����һ�������Ǹ������� m?x?n?�������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 *
 * ˵����ÿ��ֻ�����»��������ƶ�һ����
 *
 * ʾ��:
 *
 * ����:
 * [
 * ? [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * ���: 7
 * ����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-path-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 */
public class LeetCode_64_379 {
    //��̬�滮 ��ά���� �Զ�����
    /** �ظ��ԣ�Min(dp[i,j-1],dp[i-1,j])+grip[i,j];
     *  ����״̬���� dp[i,j]
     *  DP���̣�dp[i,j]=Min(dp[i,j-1],dp[i-1,j])+grip[i,j];
     *
     *  ִ����ʱ : 3 ms , ������ Java �ύ�л����� 86.46% ���û�
     *  �ڴ����� : 41.7 MB , ������ Java �ύ�л����� 39.54% ���û�
    */
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0) return 0;

        int dp[][]=new int [grid.length][grid[0].length];



        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //��Ե�ж�
                if(i==0 && j==0){
                    //��һ��λ��
                    //��ʼ��һ��λ��
                    dp[0][0]=grid[0][0];
                }
                //����
                else if(i==0 && j>0){
                    dp[i][j]= dp[i][j-1]+grid[i][j];
                }else if(i>0 && j==0){
                    //������ж�
                    dp[i][j]= dp[i-1][j]+grid[i][j];
                }else{
                    //����λ��
                    dp[i][j]= Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
                }
                //System.out.println(i+"===="+j+"==="+dp[i][j]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    /**
     * һά��̬�淶���Զ�����
     *  �ظ��ԣ� Min(dp[j-1],dp[j]])+grip[i,j];
     *  ����״̬���� dp[i,j]
     *  DP���̣�dp[j]=Min(dp[j-1],dp[j])+grip[i,j];
     *
     *  ִ����ʱ : 3 ms , ������ Java �ύ�л����� 86.46% ���û�
     *  �ڴ����� : 42.4 MB , ������ Java �ύ�л����� 23.65% ���û�
     */
    public int minPathSum2(int[][] grid) {
        if(grid==null || grid.length==0) return 0;

        int dp[]=new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
               // System.out.println(i+"===="+j+"==="+dp[i]);
                if(i==0 && j>0){
                    dp[j]=grid[i][j]+dp[j-1];
                }
                else if(j==0){
                    dp[j]=grid[i][j]+dp[j];
                }else{
                    dp[j]=Math.min(dp[j-1],dp[j])+grid[i][j];
                }
            }
        }
        return dp[grid[0].length-1];
    }
}
