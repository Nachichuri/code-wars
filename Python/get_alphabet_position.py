# You are required to, given a string, replace every letter with its position
# in the alphabet. If anything in the text isn't a letter, ignore it and don't
# return it.

import string

def get_alphabet_position(text):
    # For the sake of making it with list comprehension:
    return " ".join([str(string.ascii_lowercase.index(l.lower())+1) for l in text if l.lower() in string.ascii_lowercase])

# Best answer in CodeWars:
# Without using the string library.
# def alphabet_position(text):
#     return ' '.join(str(ord(c) - 96) for c in text.lower() if c.isalpha())