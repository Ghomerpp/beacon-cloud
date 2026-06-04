import java.util.HashSet;
import java.util.Set;

//最长连续序列
public class leetcode128 {
    public int longestConsecutive(int[] nums){
        //把数组都存入HashSet，即能快速查找，又能去重
        Set<Integer> st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }

        //记录答案
        int ans = 0;
        //遍历每一个值，找到他连排数组中的最小数
        for(int x : st){
            if(st.contains(x - 1)){
                continue;
            }
            //走到这一步，x
            int y = x + 1;
            while (st.contains(y)){
                y++;
            }
            ans = Math.max(ans,y - x);
            //如果ans大于总数组的一半，说明它就是最大的
            if (ans > st.size()/2){
                return ans;
            }
        }
        return ans;
    }
}
