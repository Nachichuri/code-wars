# Create a RomanNumerals class that can convert a roman numeral to and from an
# integer value.

class RomanNumerals:
    values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 8, 7, 6, 4, 5, 1]
    symbols = ['M','CM','D','CD','C','XC','L','XL','X','IX','VIII','VII','VI','IV','V','I']


    @classmethod
    def from_roman(cls, roman_number):
        answer = 0

        while len(roman_number) > 0:
            for item in cls.symbols:
                if item in roman_number:
                    answer += cls.values[cls.symbols.index(item)]
                roman_number = roman_number.replace(item, '', 1)

        return answer


    @classmethod
    def to_roman(cls, integer):
        answer = ''

        i = 0
        while integer > 0:
            for value in range(integer // cls.values[i]):
                answer += cls.symbols[i]
                integer -= cls.values[i]
            i += 1

        return answer