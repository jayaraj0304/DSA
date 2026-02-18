class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max1=float('-inf')
        sum=0
        n=len(nums)
        for i in range(n):
            sum+=nums[i]
            max1=max(max1,sum)
            if sum<0:
                sum=0
        return max1
            


        