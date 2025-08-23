class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        ans, sol = [], []

        def backtrack():
            if len(sol) == n:
                ans.append(sol[:])   # store a copy of current permutation
                return

            for x in nums:
                if x not in sol:     # ensure element not already used
                    sol.append(x)
                    backtrack()
                    sol.pop()        # backtrack step

        backtrack()
        return ans
