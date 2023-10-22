# Python for LeetCode

## A couple of differences from Java

```python
5 / 2              # 2.5
5 // 2             # 2
-3 // 2            # -2
int(-3 // 2)       # -1

10 % 3             # 1
-10 % 3            # 2
math.fmod(-10, 3)  # -1.0
```

## Using `math` module

```python
math.floor(3 / 2)  # 1
math.ceil(3 / 2)   # 2
math.sqrt(2)       # 1.4142135623730951
math.pow(2, 3)     # 8.0
```

```python
float('inf')      # Integer.MAX_VALUE
float('-inf')     # Integer.MIN_VALUE
```

## Using dynamic array

```python
arr = [1, 2, 3]
arr = [1] * 5
arr = [[0] * 4 for i in range(4)] # 2D array
arr = [i for i in range(5)]
arr = [i for i in range(5)] # List comprehension

# This won't work
# arr = [[0] * 4] * 4

# use as stack
arr.append(1)
arr.pop()
arr.insert(1, 7)

# index
arr[-1]  
arr[1:3]  # last index is non-inclusive
arr[100]  # no out of bounds error
```

## Loop a array

```python
# Unpacking
a, b, c = [1, 2, 3]  

# Using index
for i in range(len(nums)):
    print(nums[i])

# Without index
for n in nums:
    print(n)

# With index and value
for i, n in enumerate(nums):
    print(i, n)

# Loop through multiple arrays simultaneously with unpacking
nums1 = [1, 3, 5]
nums2 = [2, 4, 6]
for n1, n2 in zip(nums1, nums2):
    print(n1, n2)
```

## Operations on array

```python
nums.reverse()
arr.sort()
arr.sort(reverse=True)
arr.sort(key=lambda x: len(x)) # asceding order
arr.sort(key=lambda x: len(x), reverse=True)
```

## Strings <a href="#strings" id="strings"></a>

```python
# Strings are similar to arrays
s = "abc"
s[0:2]

# But they are immutable
# s[0] = "A"

# So this creates a new string, O(n) time complexity
s += "def"

# Valid numeric strings can be converted
int("123")
# And numbers can be converted to strings
str(123)

# ASCII value of a char
ord("a") # 97
ord("b") # 98

# Combine a list of strings (with an empty string delimitor)
strings = ["ab", "cd", "ef"]
print("".join(strings))
```

## Queues <a href="#queues" id="queues"></a>

```python
# Queues (double ended queue)
from collections import deque

queue = deque()
queue.append(1)
queue.pop()

queue.popleft()
queue.appendleft(1)
```

## Hash Set <a href="#hashsets" id="hashsets"></a>

```python
# HashSet
mySet = set()
mySet = { i for i in range(5) } # Set comprehension

mySet.add(1)

1 in mySet

mySet.remove(2)

# list to set
set([1, 2, 3])
```

## Hash Map <a href="#hashmaps" id="hashmaps"></a>

```python
# HashMap (aka dict)
myMap = {}
myMap = { "alice": 90, "bob": 70 }
myMap = { i: 2*i for i in range(3) } # Dict comprehension

myMap["alice"] = 88

"alice" in myMap
myMap.pop("alice")

for key in myMap:
    print(key, myMap[key])

for val in myMap.values():
    print(val)

for key, val in myMap.items():
    print(key, val)
```

## Tuples <a href="#tuples" id="tuples"></a>

```python
# Tuples are like arrays but immutable
tup = (1, 2, 3)
print(tup)
print(tup[0])
print(tup[-1])

# Can't modify
# tup[0] = 0

# Can be used as key for hash map/set
myMap = { (1,2): 3 }
myMap[(1,2)]

mySet = set()
mySet.add((1, 2))
print((1, 2) in mySet)

# Lists can't be keys
# myMap[[3, 4]] = 5
```

## Min Heaps by default <a href="#heaps" id="heaps"></a>

```python
import heapq

# under the hood are arrays
minHeap = []
heapq.heappush(minHeap, 3)

# Min is always at index 0
minHeap[0]

# Treveral the heap
while len(minHeap):
    print(heapq.heappop(minHeap))
```

```python
# Build heap from initial values
arr = [2, 1, 8, 4, 5]
heapq.heapify(arr)
```

## Max Heaps <a href="#heaps" id="heaps"></a>

```python
# No max heaps by default, work around is
# to use min heap and multiply by -1 when push & pop.
maxHeap = []
heapq.heappush(maxHeap, -3)
heapq.heappush(maxHeap, -2)
heapq.heappush(maxHeap, -4)

# Max is always at index 0
print(-1 * maxHeap[0])

# Treveral the heap
while len(maxHeap):
    print(-1 * heapq.heappop(maxHeap))
```

## Inner Functions <a href="#functions" id="functions"></a>

```python
def myFunc(n, m):
    return n * m

print(myFunc(3, 4))# Nested functions have access to outer variables
def outer(a, b):
    c = "c"

    def inner():
        return a + b + c
    return inner()

print(outer("a", "b"))

# Can modify objects but not reassign
# unless using nonlocal keyword
def double(arr, val):
    def helper():
        # Modifying array works
        for i, n in enumerate(arr):
            arr[i] *= 2
        
        # will only modify val in the helper scope
        # val *= 2

        # this will modify val outside helper scope
        nonlocal val
        val *= 2
    helper()
    print(arr, val)

nums = [1, 2]
val = 3
double(nums, val)
```

## Classes <a href="#classes" id="classes"></a>

```python
class MyClass:
    # Constructor
    def __init__(self, nums):
        # Create member variables
        self.nums = nums
        self.size = len(nums)
    
    # self key word required as param
    def getLength(self):
        return self.size

    def getDoubleLength(self):
        return 2 * self.getLength()

myObj = MyClass([1, 2, 3])
print(myObj.getLength())
print(myObj.getDoubleLength())
```

## Reference

[https://neetcode.io/courses/lessons/python-for-coding-interviews](https://neetcode.io/courses/lessons/python-for-coding-interviews)

[https://youtu.be/0K\_eZGS5NsU?si=JB-nGllZOXnHhqju](https://youtu.be/0K\_eZGS5NsU?si=JB-nGllZOXnHhqju)

