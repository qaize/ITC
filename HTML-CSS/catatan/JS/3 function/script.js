// function penjumlahan(np, nk) {
//   return np + nk;
// }

// console.log(penjumlahan);

// // bydefault
// function penjumlahan(np, nk = 5) {
//   return np + nk;
// }

// const penjumlahan = (np, nk) => {
//   return np + nk;
// };

let counter = 0;

function cobaForEach(array, fungsi) {
  fungsi(array[counter]);

  counter++;
  if (array.length != counter) {
    cobaForEach(array, fungsi);
  } else {
    counter = 0;
  }
}

cobaForEach([1, 2, 3, 4], (value) => {
  value = value + 5;
  console.log(value);
});
