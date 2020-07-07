// ROT13 is a simple letter substitution cipher that replaces a letter with the letter 13 letters after it in the alphabet.
// ROT13 is an example of the Caesar cipher.
// Create a function that takes a string and returns the string ciphered with Rot13.
// If there are numbers or special characters included in the string, they should be returned as they are.
// Only letters from the latin/english alphabet should be shifted, like in the original Rot13 "implementation".

function rot13(message) {
  let result = message.split("");
  // We'll play with Unicode values found with String.charCodeAt()
  let upperA = 65;
  let upperZ = 90;
  let lowerA = 97;
  let lowerZ = 122;
  let unicodeTurn = 0;

  for (let i = 0; i < result.length; i++) {
    if (result[i].charCodeAt() >= upperA && upperZ >= result[i].charCodeAt()) {
      if (result[i].charCodeAt(0) + 13 > upperZ) {
        unicodeTurn = result[i].charCodeAt(0) + 13 - upperZ - 1;
        result[i] = String.fromCharCode(upperA + unicodeTurn);
      } else {
        result[i] = String.fromCharCode(result[i].charCodeAt(0) + 13);
      }
    } else if (
      result[i].charCodeAt() >= lowerA && lowerZ >= result[i].charCodeAt()) {
      if (result[i].charCodeAt(0) + 13 > lowerZ) {
        unicodeTurn = result[i].charCodeAt(0) + 13 - lowerZ - 1;
        result[i] = String.fromCharCode(lowerA + unicodeTurn);
      } else {
        result[i] = String.fromCharCode(result[i].charCodeAt(0) + 13);
      }
    }
  }

  return result.join("");
}

// Best answer in CodeWars:
// I mean, it's clever but... hardcoding the alphabets? What's the fun in that?
// function rot13(message) {
//     var a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
//     var b = "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM"
//     return message.replace(/[a-z]/gi, c => b[a.indexOf(c)])
//   }
