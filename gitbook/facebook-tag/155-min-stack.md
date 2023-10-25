# 155 Min Stack

[155. Min Stack](https://leetcode.com/problems/min-stack/)

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the `MinStack` class:

* `MinStack()` initializes the stack object.
* `void push(int val)` pushes the element `val` onto the stack.
* `void pop()` removes the element on the top of the stack.
* `int top()` gets the top element of the stack.
* `int getMin()` retrieves the minimum element in the stack.

You must implement a solution with `O(1)` time complexity for each function.

&#x20;

**Example 1:**

<pre><code><strong>Input
</strong>["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

<strong>Output
</strong>[null,null,null,null,-3,null,0,-2]

<strong>Explanation
</strong>MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
</code></pre>

&#x20;

**Constraints:**

* `-231 <= val <= 231 - 1`
* Methods `pop`, `top` and `getMin` operations will always be called on **non-empty** stacks.
* At most `3 * 104` calls will be made to `push`, `pop`, `top`, and `getMin`.





{% tabs %}
{% tab title="Python" %}
```python
class MinStack:

    def __init__(self):
        self.stk = []
        self.min_stk = []
        

    def push(self, val: int) -> None:
        self.stk.append(val)
        if not self.min_stk or val < self.min_stk[-1]:
            self.min_stk.append(val)
        else:
            self.min_stk.append(self.min_stk[-1])
        

    def pop(self) -> None:
        self.stk.pop()
        self.min_stk.pop()
        

    def top(self) -> int:
        return self.stk[-1]
        

    def getMin(self) -> int:
        return self.min_stk[-1]
```
{% endtab %}

{% tab title="Java" %}
```java
class MinStack {
    // in Deque
    // offerFirst = push
    // pollFirst = pop
    // getFirst = top
    public Deque<Integer> stk;
    public Deque<Integer> minStk; 

    public MinStack() {
        stk = new LinkedList<>();
        minStk = new LinkedList<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if (minStk.isEmpty() || val < minStk.getFirst()) {
            minStk.offerFirst(val);
        } else {
            minStk.offerFirst(minStk.getFirst());
        }
    }
    
    public void pop() {
        stk.pollFirst();
        minStk.pollFirst();
    }
    
    public int top() {
        return stk.getFirst();
    }
    
    public int getMin() {
        return minStk.getFirst();
    }
}
```
{% endtab %}
{% endtabs %}
