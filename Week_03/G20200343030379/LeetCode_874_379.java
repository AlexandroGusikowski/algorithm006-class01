package G20200343030379;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  874. ģ�����߻�����
 *
 *  ��������һ�����޴�С�����������ߣ��ӵ�?(0, 0) ����ʼ���������򱱷����û����˿��Խ��������������͵����
 *
 * -2������ת?90 ��
 * -1������ת 90 ��
 * 1 <= x <= 9����ǰ�ƶ�?x?����λ����
 * ����������һЩ���ӱ���Ϊ�ϰ��
 *
 * �� i?���ϰ���λ������� ?(obstacles[i][0], obstacles[i][1])
 *
 * �����������ͼ�ߵ��ϰ����Ϸ�����ô����ͣ�����ϰ����ǰһ�����񷽿��ϣ�����Ȼ���Լ�����·�ߵ����ಿ�֡�
 *
 * ���ش�ԭ�㵽�����˵����ŷʽ�����ƽ����
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ����: commands = [4,-1,3], obstacles = []
 * ���: 25
 * ����: �����˽��ᵽ�� (3, 4)
 * ʾ��?2��
 *
 * ����: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * ���: 65
 * ����: ����������ת�ߵ� (1, 8) ֮ǰ�������� (1, 4) ��
 * ?
 *
 * ��ʾ��
 *
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * �𰸱�֤С��?2 ^ 31
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/walking-robot-simulation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *  ������⣺
 *  https://leetcode-cn.com/problems/walking-robot-simulation/solution/mo-ni-xing-zou-ji-qi-ren-by-gpe3dbjds1/
 *  https://leetcode.com/problems/walking-robot-simulation/discuss/152412/Concise-JavaScript-solution
 *
 *
 *  ע��㡰����ע��ʹ�� ���� Set ��Ϊ���ϰ���ʹ�õ����ݽṹ���Ա����ǿ�����Ч�ؼ����һ���Ƿ����衣
 *  ����������������Ǽ�� �õ����ϰ����� ���ܻ�����Լ 10000 ����
 *
 */



public class LeetCode_874_379 {

    /**
     * ִ����ʱ : 18 ms , ������ Java �ύ�л����� 92.95% ���û�
     * �ڴ����� : 51.2 MB , ������ Java �ύ�л����� 96.15% ���û�
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        //ÿ�����������,���������Ϊ׼���� �� �� ��
        int dx[]={0,1,0,-1};
        int dy[]={1,0,-1,0};

        //����������
        int x=0,y=0;
        //�����ʶ
        int di=0;
        int maxValue=0;

        //���ϰ��浽set���ϣ�����ƥ��
        //obstacles[i][] i��ʾ�ڼ����� obstacles[i][0] x�� ,obstacles[i][1] y��
        //����x����ܴ��ڶ��y���ֵ�����Դ洢����ʹ�� Map<Integer,Set<Integer>> ����洢��key:x�ᣬvalue��y���б�
        Map<Integer,Set<Integer>> obstaceleMap=new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            //x����
            int ox=obstacles[i][0];
            //y����
            int oy=obstacles[i][1];
            if(!obstaceleMap.containsKey(ox)){
                HashSet<Integer> set = new HashSet<>();
                set.add(oy);
                obstaceleMap.put(ox,set);
            }else{
                obstaceleMap.get(ox).add(oy);
            }
        }


        //-2 ���� �� -1 ���� �� n ��ǰ����
        for (int command : commands) {
            if(command==-2){
                //��ȡ����
                di=(di+3)%4;
            }else if(command==-1){
                //��ȡ����
                di=(di+1)%4;
            }else{//ǰ������
                //��Ҫһ��һ��ǰ���������ж��Ƿ�����ϰ�
                for (int n = 0; n < command; n++) {
                    //��ȡ��ǰ���������,��ԭ��������ۼӣ�������ν���ж�
                    x+=dx[di];
                    y+=dy[di];

                    //�ж��Ƿ����ϰ������ϰ���ִ��
                    //obstaceleMap.get(x) ��ֵ��һ��y��ļ���
                    if(obstaceleMap.containsKey(x) && obstaceleMap.get(x).contains(y)){
                        //�˻�ԭ����λ��
                        x-=dx[di];
                        y-=dy[di];
                        //System.out.println("�����ϰ���ֹͣǰ����x y"+x+"__"+y);
                        break;
                    }

                    //System.out.println(x+"___"+y+"_____"+(x*x+y*y));

                    //���ش�ԭ�㵽�����˵����ŷʽ�����ƽ��������ÿһ����������ʱ�������ֵ
                    maxValue=Math.max(maxValue,x*x+y*y);
                }
            }
        }
        return maxValue;
    }


    /**
     * �Լ�������һ��
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim2(int[] commands, int[][] obstacles) {
        //��������
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};

        int x=0,y=0;
        int di=0;
        int maxvale=0;
        Map<Integer,Set<Integer>> obstaceleMap=new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            int ox=obstacles[i][0];
            int oy=obstacles[i][1];

            if(!obstaceleMap.containsKey(ox)){
                Set<Integer> set=new HashSet<>();
                set.add(oy);
                obstaceleMap.put(ox,set);

            }else{
                obstaceleMap.get(ox).add(oy);
            }

        }

        for (int command : commands) {
            if(command==-2){
                di=(di+3)%4;
            }else if(command==-1){
                di=(di+1)%4;
            }else{
                for (int i = 0; i < command; i++) {
                    x+=dx[di];
                    y+=dy[di];

                    if(obstaceleMap.containsKey(x)  && obstaceleMap.get(x).contains(y)){
                        x-=dx[di];
                        y-=dy[di];
                        break;
                    }
                    maxvale=Math.max(maxvale,x*x+y*y);
                }

            }
        }
        return maxvale;
    }

}
