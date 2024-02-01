from functools import lru_cache


class Solution:
    @lru_cache(maxsize=None)
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0:
            x = 1 / x
        n = abs(n)
        return self.myPow(x, n // 2) * self.myPow(x, n - n // 2)
