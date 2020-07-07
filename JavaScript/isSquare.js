// You like building blocks. You especially like building blocks that are squares.
// And what you even like more, is to arrange them into a square of square building blocks!
//
//  However, sometimes, you can't arrange them into a square. Instead, you end up with an ordinary rectangle! Those blasted things!
// If you just had a way to know, whether you're currently working in vain… Wait!
// That's it! You just have to check if your number of building blocks is a perfect square.
//
// Given an integral number, determine if it's a square number:
// The tests will always use some integral number, so don't worry about that in dynamic typed languages.
// Examples
// isSquare(-1) returns  false
// isSquare(0) returns   true
// isSquare(3) returns   false

var isSquare = function (n) {
  return Math.sqrt(n) % 1 === 0 ? true : false;
};

// Best answer in CodeWars:
// Ternary operator not really needed :facepalm:
// function isSquare(n) {
//     return Math.sqrt(n) % 1 === 0;
//   }
