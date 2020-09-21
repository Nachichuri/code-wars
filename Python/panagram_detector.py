# A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence
# "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).

# Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.

import string

def panagram_detector(sentence):
    return all([c in sentence.lower() for c in string.ascii_lowercase])

# Best answer in Code Wars:
#import string

#def is_pangram(s):
#    return set(string.lowercase) <= set(s.lower())