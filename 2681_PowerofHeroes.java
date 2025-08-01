import java.util.Arrays;

class Solution {
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums); 

        long mod = 1_000_000_007;
        long result = 0;
        long prefixSum = 0;

        for (int num : nums) {
            long maxSquared = ((long)num * num) % mod;

            // For every subset ending at current num, prefixSum includes min values
            long total = (maxSquared * ((prefixSum + num) % mod)) % mod;

            result = (result + total) % mod;

            // update prefix sum for next iteration (including subsets with current num)
            prefixSum = (2 * prefixSum + num) % mod;
        }

        return (int) result;
    }
}
