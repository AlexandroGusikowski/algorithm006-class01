/*����һ��������*/
/*class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int i,j;
        for (i = 0; i < nums.size(); i++)
        {
            for (j = i+1 ; j < nums.size(); j++)
            {
                if (nums[i]+nums[j]==target)
                {
                    return {i,j};
                }
                
            }
            
        }
        return {};
        
    }
};*/

/*����������ϣ��*/
/*
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> hash;
        for(int i=0;i<nums.size();i++){
            if(hash.count(target-nums[i]))
            return {hash[target-nums[i]],i};
            hash[nums[i]]=i;
        }
        return {-1,-1};
    }
};
*/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
       map<int,int> hash;
       vector<int> a(2,-1);//���ؽ������ʼ��һ����СΪ2��ֵΪ-1������
       for (int i = 0; i < nums.size(); i++)
       {
           if (hash.count(target-nums[i])>0)
           {
               /* code */a[0]=hash[target-nums[i]];
               a[1]=i;
               break;
           }
           hash[nums[i]]=i;//��������map�У���ȡ�±�
       }
       return a;
        
    }
};