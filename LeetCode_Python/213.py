class Solution:
    def rob(self, nums: List[int]) -> int:
        def rob(nums):
            if not nums:
                return 0
            if len(nums) < 3:
                return max(nums)
            dp = [nums[0], max(nums[0], nums[1])]
            for i in range(2, len(nums)):
                dp[i % 2] = max(dp[(i - 2) % 2] + nums[i - 1], dp[(i - 1) % 2])
            return max(dp)

        return max(rob(nums[0: len(nums)]), rob(nums[1: len(nums) + 1]))
