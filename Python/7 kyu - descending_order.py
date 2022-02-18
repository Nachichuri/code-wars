# 7 kyu
# Your task is to make a function that can take any non-negative integer as an
# argument and return it with its digits in descending order. Essentially,
# rearrange the digits to create the highest possible number.

def order_in_descending_order(num):
    return int("".join(sorted(list(str(num)), reverse=True)))