# Fold an array
# In this kata you have to write a method that folds a given array of integers
# by the middle x-times.
# If the count of numbers is odd, the middle number will stay. Otherwise the
# fold-point is between the middle-numbers, so all numbers would be added in a
# way. The array will always contain numbers and will never be null. If an
# array with one element is folded, it stays as the same array.

# Fold 1-times:
# [1,2,3,4,5] -> [6,6,3]

import math

def fold_array(array, runs):

    temp_array = array

    for i in range(runs):
        left = temp_array[:math.ceil(len(temp_array)/2)]
        print(left)
        right = temp_array[::-1][:math.floor(len(temp_array)/2)]
        print(right)
        for index, num in enumerate(right):
            left[index] = left[index]+num
        temp_array = left

    return temp_array

# Best solution in CodeWars:
# def fold_array(array, runs):
#     nums = list(array)
#     for _ in xrange(runs):
#         for a in xrange(len(nums) // 2):
#             nums[a] += nums.pop()
#     return nums