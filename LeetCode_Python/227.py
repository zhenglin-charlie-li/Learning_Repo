from collections import deque

from collections import deque


class Solution:
    def calculate(self, s: str) -> int:
        need_calculate = {'+', '-', '*', '/', ')'}

        def helper(s):
            stack = []
            sign = '+'
            num = 0

            while len(s) > 0:
                c = s.popleft()
                if c.isdigit():
                    num = 10 * num + int(c)

                if c == '(':
                    num = helper(s)

                if c in need_calculate or len(s) == 0:
                    if sign == '+':
                        stack.append(num)
                    elif sign == '-':
                        stack.append(-num)
                    elif sign == '*':
                        stack.append(stack.pop() * num)
                    elif sign == '/':
                        stack.append(int(stack.pop() / num))
                    num = 0
                    sign = c

                    if c == ')':
                        break

            return sum(stack)

        return helper(deque(s.replace(" ", "")))


# test
ans = Solution().calculate("1 + 1")
print(ans)
ans = Solution().calculate(" 2-1 + 2 ")
print(ans)