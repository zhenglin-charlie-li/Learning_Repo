import unittest


class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        i, j = 0, 0
        m, n = len(word), len(abbr)
        while i < m and j < n:
            # not digit
            if not abbr[j].isdigit():
                if word[i] != abbr[j]:
                    return False
                i += 1
                j += 1
            # is digit
            else:
                len_replaced = 0
                if int(abbr[j]) == 0:
                    return False
                while j < m and abbr[j].isdigit():
                    len_replaced = len_replaced * 10 + int(abbr[j])
                    j += 1
                i += len_replaced
        return i == m and j == n


# unit test for the solution
Solution().validWordAbbreviation("internationalization", "i12iz4n")
Solution().validWordAbbreviation("apple", "a2e")
Solution().validWordAbbreviation("a", "01")
Solution().validWordAbbreviation("a", "1")
Solution().validWordAbbreviation("a", "2")
