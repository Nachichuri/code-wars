// #Find the missing letter

// Write a method that takes an array of consecutive (increasing) letters as input and that returns the missing letter in the array.
// You will always get a valid array. And it will be always exactly one letter be missing. The length of the array will always be at least 2.
// The array will always contain letters in only one case.

// Example:
// ['a','b','c','d','f'] -> 'e' ['O','Q','R','S'] -> 'P'

function findMissingLetter(array) {
  var arrayString = array.join("");

  for (let i = 0; i < arrayString.length; i++)
    if (arrayString.charCodeAt(i + 1) - arrayString.charCodeAt(i) != 1)
      return String.fromCharCode(arrayString.charCodeAt(i) + 1);
}

console.log(findMissingLetter(["a", "b", "c", "d", "f"]));

// Best answer in CodeWars:
// Un poco más elegante:
// var i=array[0].charCodeAt();
// array.map(x=>  x.charCodeAt()==i?i++:i);
// return String.fromCharCode(i);
