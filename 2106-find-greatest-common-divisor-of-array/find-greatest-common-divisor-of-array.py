class Solution:
    def findGCD(self, nums: List[int]) -> int:
        low=min(nums)
        high=max(nums)
        return gcd(low,high)
        