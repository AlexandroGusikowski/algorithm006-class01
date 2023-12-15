package G20200343030379;

/**
 *  50. Pow(x, n)
 */
public class LeetCode_50_379 {
    public static void main(String[] args) {
        int x=-2147483648;
        System.out.println(-x);
        long X=x;
        long abs = -X;
        System.out.println(abs);

    }
    public double myPow(double x, int n) {
        long N=n;
        if(n<0){
            //���ڷ���abs(int),�������int����Сֵ��-2147483648����
            // �������֣�Դ���߼������С� -a �������ػ���-2147483648���Ǿ���ԭ��������,���Ա���������ת��������2147483648��û���������⡣
            //n=Math.abs(n);
            N=Math.abs(N);
            x=1/x;
        }
        return fastPow(x,N);
    }

    public double fastPow(double x, long n){

        if(n==0){
            return 1;
        }

        double val = fastPow(x, n / 2);

        if(n%2==1){
            return val*val*x;
        }

        return val*val;
    }
}
