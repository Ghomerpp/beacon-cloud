//https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
//接雨水
public class leetcode42 {
    public int trap(int[] height){
        int sum = 0;
        int max_left = 0;
        int[] max_right = new int[height.length];
        for (int i = height.length -2; i >= 1; i--) {
            max_right[i] = Math.max(max_right[i+1],height[i+1]);
        }
        for (int i = 1; i < height.length-1; i++) {
            max_left = Math.max(max_left,height[i-1]);
            int min = Math.min(max_left,max_right[i]);
            if (min > height[i]){
                sum += min-height[i];
            }
        }
        return sum;
    }
}
