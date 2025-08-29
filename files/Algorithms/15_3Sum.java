class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        //Sort array
        Arrays.sort(nums);

        // Fix one number at a time
        for(int i=0; i< nums.length - 2; i++){
            //Skip duplicates for the fixed number
            if(i>0 && nums[i] == nums[i - 1]) continue;

            int left = i+1;
            int right = nums.length - 1;

            // using two pointers to find two numbers that sum  to -nums[i] 
            //(NOTE: nums[i] + nums[j] + nums[k] == 0 rearanged to: nums[j] + nums[k] == -nums[i])
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    left++; // Need a larger number

                } else {
                    right--; // Need a smaller number
                }
            }
        }

        return result;
    }
}
