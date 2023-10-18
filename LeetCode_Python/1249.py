import collections


class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        s_ptr = 0
        stack = collections.deque()
        to_delete_idx = set()
        while s_ptr < len(s):
            if s[s_ptr] == '(':
                stack.append(s_ptr)
            elif s[s_ptr] == ')':
                if not stack:
                    to_delete_idx.add(s_ptr)
                else:
                    stack.pop()
            s_ptr += 1
        for right_parenthese in stack:
            to_delete_idx.add(right_parenthese)
        res = ""
        for i in range(0, len(s)):
            if i in to_delete_idx:
                continue
            res = res + s[i]
        return res


# Create an instance of the Solution class
solution_instance = Solution()

# Call the method with the input string 's'
result = solution_instance.minRemoveToMakeValid("))((")

# Print or use the result as needed
print(result)


class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        def delete_invalid_closing(s: str, open: str, close: str) -> str:
            balance = 0
            res = []
            for i, char in enumerate(s):
                if char == open:
                    balance += 1
                elif char == close:
                    if balance == 0:
                        continue
                    else:
                        balance -= 1
                res.append(char)
            return "".join(res)

        delete_closing = delete_invalid_closing(s, "(", ")")
        delete_opening = delete_invalid_closing(delete_closing[::-1], ")", "(")
        return delete_opening[::-1]


# Create an instance of the Solution class
solution_instance = Solution()

# Call the method with the input string 's'
result = solution_instance.minRemoveToMakeValid("lee(t(c)o)de)")

# Print or use the result as needed
print(result)