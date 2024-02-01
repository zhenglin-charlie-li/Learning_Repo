from collections import OrderedDict

class Solution:
    def lengthOfLongestSubstringKDistinct(self, s, k):
        if s is None or len(s) == 0:
            return 0

        last_occurrence = OrderedDict()
        in_window_frequency = {}

        l, r = 0, 0
        res = 0

        for r in range(len(s)):
            ch = s[r]
            in_window_frequency[ch] = in_window_frequency.get(ch, 0) + 1

            while len(in_window_frequency) > k:
                first = next(iter(last_occurrence))
                out = last_occurrence[first]
                in_window_frequency[out] -= 1
                if in_window_frequency[out] == 0:
                    del in_window_frequency[out]
                del last_occurrence[first]
                l = first + 1

            last_occurrence[r] = ch
            res = max(res, r - l + 1)

        return res

# class Solution:
#     def lengthOfLongestSubstringKDistinct(self, s, k):
#         hash_map = {}
#         ans = 0
#         l, r = 0, 0
#         while r < len(s):
#             ch = s[r]
#             hash_map[ch] = hash_map.get(ch, 0) + 1
#             while len(hash_map) > k:
#                 del_ch = s[l]
#                 hash_map[del_ch] = hash_map[del_ch] - 1
#                 if hash_map[del_ch] == 0:
#                     del hash_map[del_ch]
#                 l += 1
#             ans = max(ans, r - l + 1)
#             r += 1
#         return ans

# Example usage:
sol = Solution()
s1 = "eceba"
k1 = 2
print(sol.lengthOfLongestSubstringKDistinct(s1, k1))  # Output: 3

s2 = "aa"
k2 = 1
print(sol.lengthOfLongestSubstringKDistinct(s2, k2))  # Output: 2

s3 = "a"
k3 = 1
print(sol.lengthOfLongestSubstringKDistinct(s3, k3))  # Output: 1

s4 = "bacc"
k4 = 2
print(sol.lengthOfLongestSubstringKDistinct(s4, k4))  # Output: 3

s5 = "abaccc"
k5 = 2
print(sol.lengthOfLongestSubstringKDistinct(s5, k5))  # Output: 4

s6 = "abaccc"
k6 = 3
print(sol.lengthOfLongestSubstringKDistinct(s6, k6))  # Output: 6

s7 = "abaccc"
k7 = 4
print(sol.lengthOfLongestSubstringKDistinct(s7, k7))  # Output: 6
