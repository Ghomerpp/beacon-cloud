import java.util.HashMap;
import java.util.Map;

//两数之和
//https://leetcode.cn/problems/two-sum/description/
public class leetcode01 {
    public int[] twosum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
