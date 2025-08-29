# Goal: Given an integer k, return the k-th character (1-based indexing) in word after enough operations that the string is at least k characters long.

class Solution:
    def kthCharacter(self, k: int, word="a") -> str:
        # Base case: return the k-th character once the string is long enough
        if len(word) >= k:
            return word[k - 1]

        # Generate the next part by shifting each character to the next in the alphabet
        next_part = "".join(
            chr((ord(c) - ord('a') + 1) % 26 + ord('a')) for c in word
        )

        # Recursive call with the updated word
        return self.kthCharacter(k, word + next_part)
