import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0L;
        Map<Integer, Integer> map = new HashMap<>();
        long curSum = 0L;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0) {
                int c = map.remove(nums[i - k]);
                c--;
                if (c > 0) {
                    map.put(nums[i - k], c);
                }else count--;
                
                curSum -= nums[i - k];
            }

            if (!map.containsKey(nums[i])) {
                curSum += nums[i];
                map.put(nums[i], 1);
                count++;
            }else {
                int c = map.get(nums[i]);
                c++;
                map.put(nums[i], c);
                curSum += nums[i];
            }
            
            if (count == k) {
                
                res = Math.max(res, curSum);
            }
        }

        return res;
    }
}