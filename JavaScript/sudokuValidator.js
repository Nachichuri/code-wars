// Sudoku Solution Validator

// Write a function validSolution/ValidateSolution/valid_solution() that accepts a 2D array representing a Sudoku board,
// and returns true if it is a valid solution, or false otherwise. The cells of the sudoku board may also contain 0's,
// which will represent empty cells. Boards containing one or more zeroes are considered to be invalid solutions.
// The board is always 9 cells by 9 cells, and every cell only contains integers from 0 to 9.

// <!---->

// Note: Although it asks only for a single function, I ended up with 67 lines, and no function/method should be that long.
// I refactored it in different functions:

function validSolution(board) {
  let sudokuSum = 45; // This is the sum of 1-9 that has to happen in every row, column and 3x3 grid

  // First we check if there's a 0 anywhere
  // Iteration shouldn't hurt that much since the input is always a 9x9 grid
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board.length; j++) {
      if (board[i][j] === 0) {
        return false;
      }
    }
  }

  return rowAndColumnCheck(board, sudokuSum) && squareCheck(board, sudokuSum);
}

let rowAndColumnCheck = (b, sudokuSum) => {
  for (let i = 0; i < b.length; i++) {
    if (
      b[0][i] + b[1][i] + b[2][i] + b[3][i] + b[4][i] + b[5][i] + b[6][i] + b[7][i] + b[8][i] !== sudokuSum ||
      b[i][0] + b[i][1] + b[i][2] + b[i][3] + b[i][4] + b[i][5] + b[i][6] + b[i][7] + b[i][8] !== sudokuSum
    ) {
      return false;
    }
    return true;
  }
};

let squareCheck = (b, sudokuSum) => {
  for (let i = 0; i < b.length; i += 3) {
    let cRow = 0;
    let cColumn = 0;
    for (let j = 0; j < b.length; j += 3) {
      if (
        b[j][cRow] + b[j][cRow + 1] + b[j][cRow + 2] +
        b[j + 1][cRow] + b[j + 1][cRow + 1] + b[j + 1][cRow + 2] +
        b[j + 2][cRow] + b[j + 2][cRow + 1] + b[j + 2][cRow + 2] !== sudokuSum
      ) {
        return false;
      }
      cRow += 3;
    }
    cColumn += 3;
  }
  return true;
};

// Best solution in CodeWars:
// function equals45(n){
//     return n == 45;
//   }
  
//   function validSolution(board){
//     var sumh = [0,0,0,0,0,0,0,0,0];
//     var sumv = [0,0,0,0,0,0,0,0,0];
//     osums = [[0,0,0],[0,0,0],[0,0,0]];
//     for (var i=0;i<9;i++){
//       for (var j=0;j<9;j++){
//         sumh[i] += board[i][j];
//         sumv[j] += board[i][j];
//         osums[Math.floor(i/3)][Math.floor(j/3)] += board[i][j];
//       }
//     }
//     for (var i=0;i<3;i++) if (!osums[i].every(equals45)) return false;
//     return (sumh.every(equals45) && sumv.every(equals45));
//   }