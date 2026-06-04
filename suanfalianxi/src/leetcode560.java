import java.util.HashMap;

//https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
//和为K的子数租组
public class leetcode560 {
    public int subarraySum(int[] nums,int k){
        int len = nums.length;
        int[] preSum = new int[len+1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int res = 0;
        HashMap<Integer,Integer> preCnt = new HashMap<>();
        for(int sj : preSum){
            int si = sj - k;
            if(preCnt.containsKey(si)){
                res += preCnt.get(si);
            }
            preCnt.put(sj,preCnt.getOrDefault(sj,0) + 1);
        }
        return res;
    }
}
