// Pete likes to bake some cakes. He has some recipes and ingredients. Unfortunately he is not good in maths.
// Can you help him to find out, how many cakes he could bake considering his recipes?

// Write a function cakes(), which takes the recipe (object) and the available ingredients (also an object) and returns the maximum number of cakes Pete
// can bake (integer). For simplicity there are no units for the amounts (e.g. 1 lb of flour or 200 g of sugar are simply 1 or 200).
// Ingredients that are not present in the objects, can be considered as 0.

// Examples:
// // must return 2
// cakes({flour: 500, sugar: 200, eggs: 1}, {flour: 1200, sugar: 1200, eggs: 5, milk: 200});
// // must return 0
// cakes({apples: 3, flour: 300, sugar: 150, milk: 100, oil: 100}, {sugar: 500, flour: 2000

function cakes(recipe, available) {
  const recetaKeys = Object.keys(recipe);
  let resultado = 0;

  // Primero que nada, comparemos las keys de los objetos para descartar que haya más requisitos que ingredientes disponibles
  if (recetaKeys.length > Object.keys(available).length) return 0;

  // Comparamos el contenido de cada propiedad para verificar que haya suficiente, y nos fijamos cual es el valor menor de ingredientes disponibles respecto a la receta
  for (let i = 0; i < recetaKeys.length; i++) {
    if (available.hasOwnProperty(recetaKeys[i])) {
      let division = available[recetaKeys[i]] / recipe[recetaKeys[i]];
      resultado = (resultado === 0) ? division : (division < resultado) ? division : resultado; // Esta es la definicion de wikipedia de Ternary heaven (?)
    }
  }

  return Math.floor(resultado);
}

// Mejor solución en CodeWars:
// function cakes(recipe, available) {
//     return Object.keys(recipe).reduce(function(val, ingredient) {
//       return Math.min(Math.floor(available[ingredient] / recipe[ingredient] || 0), val)
//     }, Infinity)
//   }
