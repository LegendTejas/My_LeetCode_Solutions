class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0; // Slow pointer keeps track of the last position of a unique element. It will be used to place the next unique element.
        // j is the fast pointer scanning the array to find new unique values. Starts from 1 because we assume the first element (nums[0]) is already unique.
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;               // Move slow pointer
                nums[i] = nums[j]; // Overwrite with unique element
            }
        }
        return i + 1; // Length = last index + 1
    }
}
