// Build Tower
// Build Tower by the following given argument:
// number of floors (integer and always greater than 0).
// Tower block is represented as *
//     JavaScript: returns an Array;

// for example, a tower of 3 floors looks like below
// [
//   '  *  ',
//   ' *** ',
//   '*****'
// ]

function towerBuilder(nFloors) {
  let base = "*".repeat(nFloors * 2 - 1);
  let arbol = [base];

  for (let i = 0; i < nFloors; i++) {
    if (base.replace(/[^*]/g, "").length === 1) break;

    base =
      base.substring(0, base.indexOf("*")) +
      " " +
      base.substring(base.indexOf("*") + 1);
    base =
      base.substring(0, base.lastIndexOf("*")) +
      " " +
      base.substring(base.lastIndexOf("*") + 1);

    arbol.unshift(base);
  }

  return arbol;
}

console.log(towerBuilder(99));

// Best answer in CodeWars:
//  return Array.from({length: n}, function(v, k) {
//     const spaces = ' '.repeat(n - k - 1);
//     return spaces + '*'.repeat(k + k + 1) + spaces;
//   });
