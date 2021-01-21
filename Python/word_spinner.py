# 6 kyu
# Write a function that takes in a string of one or more words, and returns the same string, but with all five or more
# letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces.
# Spaces will be included only when more than one word is present.
# Example: spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"

def spin_words(sentence):
    answer = []
    words = sentence.split(" ")

    for item in words:
        if (len(item) >= 5):
            answer.append(item[::-1])
        else:
            answer.append(item)

    return " ".join(answer)

# Best answer in CodeWars:
# def spin_words(sentence):
#     # Your code goes here
#     return " ".join([x[::-1] if len(x) >= 5 else x for x in sentence.split(" ")])