class Solution {
    public boolean isPowerOfThree(int number) {
        // Base case: power of 3 must be a positive number
        if (number <= 0) {
            return false;
        }

        // Keep dividing the number by 3 as long as it's divisible
        while (number % 3 == 0) {
            number = number / 3;
        }

        // If we finally reach 1, it means the original number was a power of 3
        return number == 1;
    }
}
