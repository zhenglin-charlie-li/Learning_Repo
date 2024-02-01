# Given a sorted array having where all elements are repeated twice but one is repeated thrice,
# find the element repeated thrice in O(logn) time.

def find_third_number(nums):
    l, r = 0, len(nums) - 1  # l, r = 0, 6

    while l < r:
        mid = (l + r) // 2  # l, r = 4,6 mid = 5
        if mid % 2 == 0:
            if mid + 1 <= len(nums) - 1 and nums[mid] == nums[mid + 1]:
                l = mid + 1
            else:
                r = mid - 1
        else:
            # mid is odd
            if mid - 1 >= 0 and nums[mid] == nums[mid - 1]:
                l = mid + 1  # l = 4
            else:
                r = mid - 1  # r=5
        # l >= r
    return nums[l]


# test
nums = [1, 1, 1, 2, 2, 3, 3]
print(find_third_number(nums))
nums = [1, 1, 1, 2, 2, 3, 3, 4, 4]
print(find_third_number(nums))
nums = [1, 1, 2, 2, 3, 3, 4, 4, 4]
print(find_third_number(nums))
# Test cases for elements repeated thrice

nums = [1, 1, 1, 2, 2, 3, 3]
print(find_third_number(nums))  # Output: 3

nums = [1, 1, 1, 2, 2, 3, 3, 4, 4]
print(find_third_number(nums))  # Output: 4

nums = [1, 1, 2, 2, 3, 3, 4, 4, 4]
print(find_third_number(nums))  # Output: 4

# Test cases for elements repeated once
nums = [1, 2, 2, 3, 3, 3, 4, 4, 4]
print(find_third_number(nums))  # Output: 1

nums = [1, 1, 2, 2, 2, 3, 3, 4]
print(find_third_number(nums))  # Output: 4

# Test cases for large input
nums = [1, 1, 2, 2,  3, 3,4, 4, 5, 5,6, 6, 7, 7,7]
print(find_third_number(nums))  # Output: 4
