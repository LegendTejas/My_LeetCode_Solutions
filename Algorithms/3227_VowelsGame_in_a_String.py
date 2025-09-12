class Solution:
    def doesAliceWin(self, s: str) -> bool:
        '''
        Check if Alice wins based on the presence of vowels in the given string.

        Alice wins if the string `s` contains at least one vowel (a, e, i, o, u in either case).
        If no vowel is found in the string, Alice does not win.

        Args:
            s (str): The input string to be checked.

        Returns:
            bool: True if at least one vowel is present in the string, otherwise False.
        '''
        
        vowel = 'aeiouAEIOU'
        for i in vowel:
            if i in s:
                return True
        else:
            return False
