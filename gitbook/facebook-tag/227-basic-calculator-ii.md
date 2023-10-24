# 227 Basic Calculator II

[227. Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/)

Given a string `s` which represents an expression, _evaluate this expression and return its value_.&#x20;

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of `[-231, 231 - 1]`.

**Note:** You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as `eval()`.

&#x20;

**Example 1:**

<pre><code><strong>Input: s = "3+2*2"
</strong><strong>Output: 7
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: s = " 3/2 "
</strong><strong>Output: 1
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: s = " 3+5 / 2 "
</strong><strong>Output: 5
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= s.length <= 3 * 105`
* `s` consists of integers and operators `('+', '-', '*', '/')` separated by some number of spaces.
* `s` represents **a valid expression**.
* All the integers in the expression are non-negative integers in the range `[0, 231 - 1]`.
* The answer is **guaranteed** to fit in a **32-bit integer**.

{% tabs %}
{% tab title="First Tab" %}
```python
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

```
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}

[https://leetcode.cn/problems/basic-calculator-ii/solutions/91271/chai-jie-fu-za-wen-ti-shi-xian-yi-ge-wan-zheng-ji-/comments/706384](https://leetcode.cn/problems/basic-calculator-ii/solutions/91271/chai-jie-fu-za-wen-ti-shi-xian-yi-ge-wan-zheng-ji-/comments/706384)

<details>

<summary>解释</summary>

解释一下为什么使用python中的list,而且还需要一个个的pop，直接遍历不行吗？答案是不行。 以下是我跟着楼主一步步写的python的代码，在楼主使用java for循环遍历字符串的时候，我也用python的for循环进行遍历，但是到最后楼主写python代码直接使用了列表，然后一个个元素地弹出，一开始有点不理解，后来发现确实应该这样做。大家可以跟着我写的python代码再回顾一遍。

#### 1.字符串转整数 <a href="#1-zi-fu-chuan-zhuan-zheng-shu" id="1-zi-fu-chuan-zhuan-zheng-shu"></a>

如何把一个字符串形式的正整数转化为int类型？

```python
s = '456'
n = 0
for i in s:
	n = 10 * n + (ord(i) - ord('0'))
```

这里需要注意的就是python不可以直接字符相减，所以需要加上ord，然后不要忘了括号。

#### 2.处理不带空格的加减法 <a href="#2-chu-li-bu-dai-kong-ge-de-jia-jian-fa" id="2-chu-li-bu-dai-kong-ge-de-jia-jian-fa"></a>

比如1-12+3

1. 先给第一个数字加一个默认的符号+，变成+1-12+3
2. 把一个运算符和数字组合成一对，也就是+1 -12 +3，把它们转化为数字，然后放到一个栈中
3. 将栈中所有的数字求和，就是原算式的结果

```python
def calculate(self, s: str) -> int:
        stack = []
        #用num来记录算式中的数字
        num = 0
        #记录数字前的sign，初始化为+
        sign = '+'
        for i in range(len(s)):
            #如果当前为数字
            if s[i].isdigit():
                num = num * 10 + (int(s[i]))
            #如果当前不是数字，因为也没有空格，所以当前遇到的是下一个符号
            if not s[i].isdigit() or i == len(s) - 1:
                #一定注意需要把之前计算的数字和符号都存入栈中
                if sign == '+':
                    stack.append(num)
                else:
                    stack.append(-num)
                #更新符号 数字清零
                sign = s[i]
                num = 0
        return sum(stack)
```

#### 处理乘除法 <a href="#chu-li-cheng-chu-fa" id="chu-li-cheng-chu-fa"></a>

这里加上乘法和除法的思路依旧是把字符串分解成为符号和数字的组合。比如2-3\*4+5为例，就分解成为+2,-3,\*4,+5，在上面的基础上其他部分不变，只需要在前面sign的讨论里加上相应的case就可以了。

```python
class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        #用num来记录算式中的数字
        num = 0
        #记录数字前的sign，初始化为+
        sign = '+'
        for i in range(len(s)):
            #如果当前为数字
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            #如果当前不是数字，因为也没有空格，所以当前遇到的是下一个符号
            if (not s[i].isdigit()) or (i == len(s) - 1):
                #一定注意需要把之前计算的数字和符号都存入栈中
                if sign == '+':
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)
                #碰上* / 只需要拿出前一个数字进行相应的运算然后再压栈就可以了
                elif sign == '*':
                    stack.append(stack.pop() * num)
                else:
                    #注意python的//是向下取整，如果-5//2 = -3这显然不是我们想要的结果，除法向0取整应该使用下面的方法 python3中默认的除法是真除法
                    stack.append(int(stack.pop() / num))
                #更新符号 数字清零
                sign = s[i]
                num = 0
        return sum(stack)
```

**这里乘除法的优先级就体现在乘除法可以和栈顶的数相结合，但是加减法只能把自己放入栈中。**

#### 处理空格 <a href="#chu-li-kong-ge" id="chu-li-kong-ge"></a>

如果字符串中有空格，显然代码就会进入for循环中的第二个if语句，如果进入了之后更新符号那里就会把符号更新为空格，所以我们应该忽略空格，我们只需要在第二个if上加入限制条件跳过即可。

```python
if (not s[i].isdigit() and s[i] != ' ') or (i == len(s) - 1):
```

经过以上思路，我们得到这个题最后的代码如下：

```python
class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        #用num来记录算式中的数字
        num = 0
        #记录数字前的sign，初始化为+
        sign = '+'
        for i in range(len(s)):
            #如果当前为数字
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            #如果当前不是数字，因为也没有空格，所以当前遇到的是下一个符号
            if ((not s[i].isdigit()) and s[i] != ' ') or (i == len(s) - 1):
                #一定注意需要把之前计算的数字和符号都存入栈中
                if sign == '+':
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)
                #碰上* / 只需要拿出前一个数字进行相应的运算然后再压栈就可以了
                elif sign == '*':
                    stack.append(stack.pop() * num)
                else:
                    #注意python的//是向下取整，如果-5//2 = -3这显然不是我们想要的结果，除法向0取整应该使用下面的方法
                    stack.append(int(stack.pop() / num))
                #更新符号 数字清零
                sign = s[i]
                num = 0
        return sum(stack)
```

#### 处理括号 <a href="#chu-li-kuo-hao" id="chu-li-kuo-hao"></a>

处理括号应该是整个问题中最难的部分。但是**括号具有递归性质**。

不管有多少层括号嵌套，都可以通过calculate函数递归地调用自己，都可以将括号中的算式花间成为一个数字。那么我们需要注意开始递归和结束递归的条件是什么，很显然，当碰到左括号的时候开始递归，当碰到有括号的时候结束递归。

所以最难的问题也解决了。

```python
class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        #用num来记录算式中的数字
        num = 0
        #记录数字前的sign，初始化为+
        sign = '+'
        for i in range(len(s)):
            #如果当前为数字
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            #碰到左括号开始递归
            if s[i] == '(':
                num = self.calculate(s[i+1:])
            #如果当前不是数字，因为也没有空格，所以当前遇到的是下一个符号
            if ((not s[i].isdigit()) and s[i] != ' ') or (i == len(s) - 1):
                #一定注意需要把之前计算的数字和符号都存入栈中
                if sign == '+':
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)
                #碰上* / 只需要拿出前一个数字进行相应的运算然后再压栈就可以了
                elif sign == '*':
                    stack.append(stack.pop() * num)
                else:
                    #注意python的//是向下取整，如果-5//2 = -3这显然不是我们想要的结果，除法向0取整应该使用下面的方法
                    stack.append(int(stack.pop() / num))
                #更新符号 数字清零
                sign = s[i]
                num = 0
            #碰到右括号返回递归结果
            if s[i] == ')':
                break
        return sum(stack)
```

然后我们使用上面的代码进行计算的时候是错误的，为什么呢，问题的关键就出在递归调用那里，想象一下递归调用完了之后已经返回了后面括号计算的结果，但是当我们进入下一个循环的时候还是会计算括号里面的值，所以我们不应该用for循环，应该把s转化为一个list之后，通过pop(0)来将s前面的数字计算之后弹出。但是list的pop(0)的复杂度要高一些，因为删除了第一个元素之后list需要内存中后面的元素需要整体向前移。所以我们这个时候可以使用deque双端队列，它的popleft()复杂度低一些。

所以代码如下：

```python
from collections import deque
class Solution:
    def calculate(self, s: str) -> int:
        s = deque(s)  
        def helper(s):
            stack = []
            sign = '+'
            num = 0

            while len(s) > 0:
                c = s.popleft()
                if c.isdigit():
                    num = 10 * num + int(c)
                # 遇到左括号开始递归计算 num
                if c == '(':
                    num = helper(s)

                if (not c.isdigit() and c != ' ') or len(s) == 0:
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
                # 遇到右括号返回递归结果
                if c == ')': break
            return sum(stack)

        return helper(s)
```



</details>
