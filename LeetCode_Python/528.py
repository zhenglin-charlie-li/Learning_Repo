import random
from typing import List


class Solution:

    def __init__(self, w: List[int]):
        self.presum = []
        self.sum = 0
        for weight in w:
            self.sum += weight
            self.presum.append(self.sum)

    def pickIndex(self) -> int:
        # [1, sum]
        x = random.randint(1, self.sum)
        idx = self.find_index(x)
        return idx

    def find_index(self, x: int) -> int:
        ans = 0
        # [l, r]
        l, r = 0, len(self.presum) - 1
        while l <= r:
            mid = (l + r) // 2
            if self.presum[mid] >= x:
                ans = mid
                r = mid - 1
            else:
                l = mid + 1
        return ans

# index: [0, 1, 2, 3]
# value: [1, 2, 3, 4]
# total: 10
# presum:[1, 3, 6, 10]
# random pick a number x from[1, 10]
# find the least number that >= x
# return the index