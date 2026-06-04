import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//找到字符串中所有字母异位词
//https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
public class leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cntP = new int[26];
        for (char c : p.toCharArray()){
            cntP[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();

        int[] cntS = new int[26];
        int pLen = p.length();

        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a']++;

            int left = right - pLen + 1;
            if(left < 0){
                continue;
            }
            if(Arrays.equals(cntS,cntP)){
                ans.add(left);
            }
            cntS[s.charAt(left) - 'a']--;
        }
        return ans;
    }
}


