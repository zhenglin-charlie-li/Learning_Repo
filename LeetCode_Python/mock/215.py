import heapq
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        nums = [-num for num in nums]
        max_heap = heapq.heapify(nums)
        while k > 1:
            k -= 1
            heapq.heappop(max_heap)
        return max_heap[0]
