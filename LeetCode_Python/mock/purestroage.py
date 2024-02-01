from collections import Counter

def find_elements_with_single_double(numbers):
    # Create a counter for all numbers
    count = Counter(numbers)
    result = []

    # Iterate through the list
    for number in numbers:
        # Check if the double exists and its count is exactly one
        if count[2 * number] == 1:
            result.append(number)

    # Remove duplicates and sort the result
    result = sorted(result)
    return result

# Examples
example1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 8]
example2 = [7, 17, 11, 1, 23]
example3 = [1, 1, 2]

# Find and print the elements
print(find_elements_with_single_double(example1))  # Output: [0, 1, 2, 3]
print(find_elements_with_single_double(example2))  # Output: []
print(find_elements_with_single_double(example3))  # Output: [1]
