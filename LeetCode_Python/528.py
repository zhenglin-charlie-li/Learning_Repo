import random
from typing import List


class Solution:

    def __init__(self, w: List[int]):
        self.pre_sum = []
        total = 0

        for weight in w:
            total = total + weight
            self.pre_sum.append(total)

        self.total = total

    def pickIndex(self) -> int:
        # [1, total]
        target = random.randint(1, self.total)
        l = 0
        r = len(self.pre_sum) - 1
        pos = 0
        while l <= r:
            mid = (l + r) // 2
            if self.pre_sum[mid] < target:
                l = mid + 1
            elif self.pre_sum[mid] >= target:
                pos = mid
                r = mid
        return pos

        # Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()

# weight:  [1, 2, 4]
# pre_sum: [1, 3, 7]
# random number x betwwen [1, 7]
# find the least number >= x