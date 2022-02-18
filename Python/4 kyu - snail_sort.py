# Given an n x n array, return the array elements arranged from outermost
# elements to the middle element, traveling clockwise.

def get_snail(snail_map):
        result = []
        while len(snail_map) > 0:
            # Right
            result += snail_map[0]
            snail_map.pop(0)

            if len(snail_map) > 0:
                # Down
                for x in snail_map:
                    result += [x[-1]]
                    x.pop(-1)
                # Left
                if snail_map[-1]:
                    result += snail_map[-1][::-1]
                    snail_map.pop(-1)
                # Up
                for x in snail_map[::-1]:
                    result += [x[0]]
                    x.pop(0)

        return result

# Best answer in CodeWars:
# def snail(array):
#     ret = []
#     if array and array[0]:
#         size = len(array)
#         for n in xrange((size + 1) // 2):
#             for x in xrange(n, size - n):
#                 ret.append(array[n][x])
#             for y in xrange(1 + n, size - n):
#                 ret.append(array[y][-1 - n])
#             for x in xrange(2 + n, size - n + 1):
#                 ret.append(array[-1 - n][-x])
#             for y in xrange(2 + n, size - n):
#                 ret.append(array[-y][n])
#     return ret
# Another guy used NumPy but I don't really think it's the idea...