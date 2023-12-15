package G20200343030379;

/**
 *  74. ������ά����
 *
 * ��дһ����Ч���㷨���ж�?m x n?�����У��Ƿ����һ��Ŀ��ֵ���þ�������������ԣ�
 *
 * ÿ���е����������Ұ��������С�
 * ÿ�еĵ�һ����������ǰһ�е����һ��������
 * ʾ��?1:
 *
 * ����:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * ���: true
 * ʾ��?2:
 *
 * ����:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * ���: false
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/search-a-2d-matrix
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �ο�������⣺
 *
 */
public class LeetCode_74_379 {

    /**
     * ���ֲ��ҷ���
     *
     * ִ����ʱ : 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 41.5 MB , ������ Java �ύ�л����� 47.05% ���û�
     *
     * ������⣺https://leetcode-cn.com/problems/search-a-2d-matrix/solution/sou-suo-er-wei-ju-zhen-by-leetcode/
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowN = matrix.length;
        if(rowN == 0) return false;

        //�ж�����
        int colM=matrix[0].length;


        int left=0,right=rowN * colM - 1;
        //�洢�У���
        int row=0,col=0;
        int mid=0;
        while (left <= right){
            mid=(left + right)/2;
            row = mid / colM;
            col = mid % colM;

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }
        return false;
    }

    /**
     * �������������Ͻǿ�ʼ����
     *
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 39.32% ���û�
     * �ڴ����� : 41.5 MB , ������ Java �ύ�л����� 48.48% ���û�
     *
     * ������⣺https://leetcode.com/problems/search-a-2d-matrix/discuss/26215/An-Easy-Solution-in-Java
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row=0;
        if(matrix.length==0) return false;
        int col=matrix[0].length-1;

        while(row < matrix.length && col >= 0){
            System.out.println(row+"--"+col+"=="+matrix[row][col]);
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                //����Ŀ��ֵ������
                col --;
            }else{
                //С��Ŀ��ֵ��������һ��
                row ++;
            }
        }
        //������ʧ�ܣ�����false
        return false;
    }


}
