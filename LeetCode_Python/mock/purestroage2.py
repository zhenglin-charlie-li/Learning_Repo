def max_consecutive_repetitions(short_s, long_s):
    # If either of the strings is empty, return 0
    if not short_s or not long_s:
        return 0

        # Start with zero repetitions and zero max
    max_reps = 0
    count = 0
    index = 0

    # While there's still string left to check
    while index < len(long_s):
        # If the current slice matches short_s, increment the count
        if long_s[index:index + len(short_s)] == short_s:
            count += 1
            index += len(short_s)
        else:
            # If not, reset the count and increment the index
            max_reps = max(max_reps, count)
            count = 0
            index += 1

    # Check the count one last time in case the string ends with a repetition
    max_reps = max(max_reps, count)

    return max_reps

# Test cases
test1 = max_consecutive_repetitions("AB", "ABBAC")
test2 = max_consecutive_repetitions("AB", "ABCABCABAB")

print(test1)
print(test2)
