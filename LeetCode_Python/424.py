class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = {}
        l, r = 0, 0

        res = 0

        while r < len(s):
            count[s[r]] = 1 + count.get(s[r], 0)
            maxf = max(count.values())

            while (r - l + 1) - maxf > k:
                count[s[l]] -= 1
                l += 1

            res = max(res, r - l + 1)
            r += 1

        return res
