"""
Hashset
Time: O(L)
Space: O(L)
"""
from typing import List


class SparseVector:
    def __init__(self, nums: List[int]):
        self.nonzeros = dict()
        for i, n in enumerate(nums):
            if n != 0:
                self.nonzeros[i] = n

    def dotProduct(self, vec: 'SparseVector') -> int:
        nonzeros1 = self.nonzeros
        nonzeros2 = vec.nonzeros
        result = 0
        for i, n in nonzeros1.items():
            if i in nonzeros2:
                result += n * nonzeros2[i]
        return result

# test
v1 = SparseVector([1, 0, 0, 2, 3])
v2 = SparseVector([0, 3, 0, 4, 0])
print(v1.dotProduct(v2))
