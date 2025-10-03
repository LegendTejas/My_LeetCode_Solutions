class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        f = collections.Counter(nums)
        mx = max(f.values())

        count = 0
        for v in f.values():
            if mx == v:
                count += v
        return count
