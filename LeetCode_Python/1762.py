from typing import List
from collections import deque


class Solution:
    def findBuildings(self, height: List[int]) -> List[int]:
        if not height:
            return []
        max_height = -1
        res = deque()
        for i in range(len(height) - 1, -1, -1):
            if height[i] > max_height:
                max_height = height[i]
                res.appendleft(i)
        return list(res)
