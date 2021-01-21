# 6 kyu
# Write a function that takes an array of numbers (integers for the tests) and
# a target number. It should find two different items in the array that, when
# added together, give the target value. The indices of these items should then
# be returned in a tuple like so: (index1, index2).
# The input will always be valid.

def get_two_sum(numbers, target):
    for key, item in enumerate(numbers):
        if target - item in numbers and key != numbers.index(target - item):
            return (key, numbers.index(target - item))


# Best rated answer:
# def two_sum(nums, t):
#     for i, x in enumerate(nums):
#         for j, y in enumerate(nums):
#             if i != j and x + y == t:
#                 return [i, j]