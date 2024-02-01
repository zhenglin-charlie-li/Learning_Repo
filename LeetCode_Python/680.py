class Solution:
    def validPalindrome(self, s: str) -> bool:
        def validPalindrome(s: str) -> bool:
            i, j = 0, len(s) - 1
            while i < j:
                if s[i] != s[j]:
                    return False
                i, j = i + 1, j - 1
            return True

        i, j = 0, len(s) - 1
        while i < j:
            if s[i] != s[j]:
                return validPalindrome(s[i + 1: j + 1]) or validPalindrome(s[i: j])
            i, j = i + 1, j - 1
        return True
