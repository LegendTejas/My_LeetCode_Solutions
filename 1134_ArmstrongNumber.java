import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input number
        int N = sc.nextInt();

        // Calculate number of digits in N
        int k = length(N);

        // Check and print if N is an Armstrong number
        System.out.println(isArmstrongNumber(N, k));

        sc.close();
    }

    /**
     * Calculates the number of digits in a number.
     * Example: length(153) → 3
     */
    public static int length(int N) {
        int length = 0;
        int temp = N; // Preserve original N for clarity
        if (temp == 0) return 1; // Special case for 0
        while (temp != 0) {
            temp /= 10; // Remove last digit
            length++;
        }
        return length;
    }

    /**
     * Checks if a number is an Armstrong number.
     * An Armstrong number is one where:
     * sum(each digit ^ total_digits) == number itself
     * Example: 153 → 1³ + 5³ + 3³ = 153 (true)
     */
    public static boolean isArmstrongNumber(int N, int k) {
        long powerSum = 0; // Use long to prevent overflow for large N
        int temp = N;

        while (temp != 0) {
            int rem = temp % 10; // Extract last digit
            powerSum += Math.pow(rem, k); // Add digit^k
            temp /= 10; // Remove last digit
        }

        return (powerSum == N); // Compare sum with original number
    }
}
