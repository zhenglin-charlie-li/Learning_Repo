import heapq
from typing import List


class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # k smallest, max heap
        max_heap = []
        heapq.heapify(max_heap)

        for x, y in points:
            heapq.heappush((- (x * x + y * y), x, y))
            if len(max_heap) > k:
                heapq.heappop(max_heap)

        res = []
        for i in range(k):
            _, x, y = heapq.heappop(max_heap)
            res.append([x, y])
        return res


Solution().kClosest([[3, 3], [5, -1], [-2, 4]], 2)
