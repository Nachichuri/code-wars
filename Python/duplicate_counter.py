# Write a function that will return the count of distinct case-insensitive
# alphabetic characters and numeric digits that occur more than once in the
# input string. The input string can be assumed to contain only alphabets (both
# uppercase and lowercase) and numeric digits.

def duplicate_count(text):
    lower_text = text.lower()
    return len({l for l in lower_text if lower_text.count(l) > 1})

# Best answer in CodeWars:
# def duplicate_count(s):
#   return len([c for c in set(s.lower()) if s.lower().count(c)>1])