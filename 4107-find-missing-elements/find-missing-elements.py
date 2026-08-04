class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        start=min(nums)
        end=max(nums)
        ar=[]
        nums_set=set(nums)
        for x in range(start,end+1):
            if x not in nums_set:
                ar.append(x)
        return ar
        