// Given: an array containing hashes of names
// Return: a string formatted as a list of names separated by commas except for the last two names, which should be separated by an ampersand.
// Example:
// list([ {name: 'Bart'}, {name: 'Lisa'}, {name: 'Maggie'} ])
// // returns 'Bart, Lisa & Maggie'
// list([ {name: 'Bart'}, {name: 'Lisa'} ])
// // returns 'Bart & Lisa'
// list([ {name: 'Bart'} ])
// // returns 'Bart'
// list([])
// // returns ''
// Note: all the hashes are pre-validated and will only contain A-Z, a-z, '-' and '.'.

function list(names) {
  // Switch case time :)
  switch (names.length) {
    case 0:
      return "";
    case 1:
      return names[0].name;
    case 2:
      return `${names[0].name} & ${names[1].name}`;
    default:
      return names
        .map((person) => {
          return person.name;
        })
        .join(", ")
        .replace(/, (?!.*, )/, " & "); // Regex magic
  }
}

// Best answer in CodeWars:
// function list(names) {
//     var xs = names.map(p => p.name)
//     var x = xs.pop()
//     return xs.length ? xs.join(", ") + " & " + x : x || ""
//   }
