import random


def generate_random_integers(n, start_range, end_range):
    """
    Generates a list of n random integers between start_range and end_range (inclusive).

    Args:
    - n (int): Number of random integers to generate.
    - start_range (int): Minimum value for the random integers.
    - end_range (int): Maximum value for the random integers.

    Returns:
    - List[int]: List of random integers.
    """
    return [random.randint(start_range, end_range) for _ in range(n)]


# Example usage:
num_integers = 1000  # Number of integers you want
min_value = 1  # Minimum value of the integers
max_value = 1000  # Maximum value of the integers

random_integers = generate_random_integers(num_integers, min_value, max_value)
print(random_integers)
