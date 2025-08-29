class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""             # stores the longest palindromic substring found
        longest_len = 0      # stores the length of that substring

        for i in range(len(s)):

            # Case 1: Odd length palindrome
            # Expand around a single center (s[i])
            # Example: "aba" -> center is 'b'
            l, r = i, i
            while l >= 0 and r < len(s) and s[l] == s[r]:
                if (r - l + 1) > longest_len:   # found a longer palindrome
                    res = s[l:r+1]
                    longest_len = r - l + 1
                l -= 1
                r += 1

            # Case 2: Even length palindrome
            # Expand around two centers (s[i], s[i+1])
            # Example: "abba" -> center is between the 2 b's
            l, r = i, i + 1
            while l >= 0 and r < len(s) and s[l] == s[r]:
                if (r - l + 1) > longest_len:   # found a longer palindrome
                    res = s[l:r+1]
                    longest_len = r - l + 1
                l -= 1
                r += 1

        return res
