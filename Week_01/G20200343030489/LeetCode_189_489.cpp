/*����һ*/
/*class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int tmp[nums.size()];

        for (int i = 0; i < nums.size(); i++)
        {
            tmp[(i+k)%nums.size()]=nums[i];
        }
        for (int i = 0; i < nums.size(); i++)
        {
            nums[i]=tmp[i];
        }
        

    }
};*/
/*�˷�����Ϊ������һ�����飬���¿ռ临�ӶȲ�ΪO��1��*/

/*������*/

/*
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int tmp;
        for (int i = 0; i < k%nums.size(); i++)
        {
            tmp=nums[nums.size()-1];
            for (int j = nums.size()-1; j >0; j--)
            {
                nums[j]=nums[j-1];
            }
            nums[0]=tmp;
        }
    }
};
*/
/*�˷���ʱ�临�Ӷȹ��ߣ�ΪO(k*n)*/

/*������*/
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
       int leng=nums.size();
       k%=nums.size();
       reverse(&nums[0],&nums[leng]);
       reverse(&nums[0],&nums[k]);
       reverse(&nums[k],&nums[leng]);
    }
};

/*�˷��������˷�ת����תreverse��������
����������������ʵ����������ת���� k �Σ� k\%nk%n ��β��Ԫ�ػᱻ�ƶ���ͷ����ʣ�µ�Ԫ�ػᱻ����ƶ���

����������У��������Ƚ�����Ԫ�ط�ת��Ȼ��תǰ k ��Ԫ�أ��ٷ�ת���� n-kn?k ��Ԫ�أ����ܵõ���Ҫ�Ľ����
*/