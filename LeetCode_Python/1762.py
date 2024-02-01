import collections
from typing import List


class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        max_height = 0
        ans = collections.deque()
        for i in range(len(heights) - 1, -1, -1):
            v = heights[i]
            if v > max_height:
                ans.append(i)
                max_height = v
        return list(ans)
