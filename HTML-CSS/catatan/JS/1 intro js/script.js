/*
let -> lokal vairable yang tidak bisa di declare berulang
var -> global vairable yang bisa di declare berulang

*/

console.log(5 + 5);

const x = 2;
console.log(x);

const tanggalLahir = new Date();

console.log(tanggalLahir);

console.log(tanggalLahir.getDay());
let a;

// back tick
console.log(`Tanggal sekarang : ${tanggalLahir}`);
console.log("Tanggal sekarang : " + tanggalLahir);

console.log("Logical statment");
console.log(1 == 1);
console.log(1 != 1);
console.log("1" === 1);
console.log("1" !== 1);
console.log("1" == 1);
console.log(1 == "1");
console.log("parse");

// parsing
console.log(Number(true));
console.log(Number(false));
console.log(Boolean(0));
console.log(Boolean(Number("0")));
console.log(Boolean("0"));

// string manipulation
// let test = "       x     ";
var test = "       x     ";

console.log(test);
console.log(test.trim());

test = "ASASasasaAsaDAa";

console.log(test.toLocaleLowerCase());
console.log(test.toUpperCase());

//lalu lintas, polisi, pengemudi
// hijau - gas
// orange - hati-hati
// merah - if trobos true polisi true - tilang

// let state = prompt("Warna Lampu ?");
// let polisi = confirm("Apakah ada Polisi ?");
// let sifatPengemudi = confirm("Apakah anda keras kepala ?");

// let kembalian = "";
// switch (state) {
//   case "hijau": {
//     kembalian = "Melaju";
//     break;
//   }
//   case "kuning":
//     kembalian = "Hati-Hati";
//     break;
//   case "merah":
//     if (polisi && sifatPengemudi) {
//       kembalian = "Busted";
//       break;
//     } else if (!polisi && sifatPengemudi) {
//       kembalian = "Tewas";
//       break;
//     } else {
//       kembalian = "Berhenti";
//       break;
//     }
//   default:
//     kembalian = "bukan lampu lalu lintas";
// }

// window.alert(kembalian);

console.log(1 + "1" + 1 + 1);
console.log("1" + (1 + 1 + 1));
console.log(2 * (1 + 1 + 1));

const array = [1, 2, 3, 4, 5];

console.log(array);
console.log(array.length);
console.log(typeof array);

//create - menambahkan nilai dan index
array.push(6);
console.log(array);

//update - berdasarkan index
array[3] = "urutan ketiga";
console.log(array);

//read
console.log(array.indexOf("urutan ketiga")); //mencetak indexnya
console.log(array[3]); //mencetak valuenya

//delete
array.pop();
console.log(array);

//delete ditengah2
console.log(array.splice(3, 1));
console.log(array);

console.log("while - loop");
let counter = 0; //penampung
while (counter < array.length) {
  // kondisi
  console.log(array[counter]);
  counter++; //penambah
}

//imperative
console.log("for loop");
for (let i = 0; i < array.length; i++) {
  console.log(array[i]);
}

console.log("for-in");
for (let nilai in array) {
  console.log(Number(nilai));
}

console.log("for-of");
for (let nilai of array) {
  console.log(nilai);
}
