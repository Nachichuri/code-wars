# Write an algorithm that takes an array and moves all of the zeros to the end,
# preserving the order of the other elements.

def move_zeros(array):

    new_list = []

    for item in array:
        if (type(item) == type(0) or type(item) == type(0.0)) and str(int(item)) == '0':
            pass
        else:
            new_list.append(item)

    return new_list + [0 for zero in range(len(array)-len(new_list))]

# Best answer in CodeWars:
# def move_zeros(arr):
#     l = [i for i in arr if isinstance(i, bool) or i!=0]
#     return l+[0]*(len(arr)-len(l))