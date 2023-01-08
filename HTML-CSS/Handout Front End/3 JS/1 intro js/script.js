let penampungLet;
const penampungConst = 1;

penampungLet = 2;
penampungLet++;

penampungLet = "String";
penampungLet = "String";

//String interpolation
penampungLet = `Nilai saya : ${penampungConst}`;

//Manipulasi String
const nilai = penampungLet.substring(0, 5);
const sayaNilai = penampungLet.substring(6);

console.log(nilai.toLowerCase());
console.log(sayaNilai.toUpperCase());

//Date Time manipulation
console.log(new Date());
//                tahun 1991 bulan 01 tanggal 01
let tanggalSekarang = new Date("December 21, 1995");
tanggalSekarang = new Date("1991/01/01");

console.log(
  `${tanggalSekarang.getFullYear()}/${
    tanggalSekarang.getMonth() + 1
  }/${tanggalSekarang.getUTCDay()}`
);

/**
 * Number
 * String
 * Object
 * Boolean
 * Function
 */

//Parsing
console.log(Boolean(0));
console.log(Boolean(4));
console.log(Boolean(""));
console.log(Boolean({}));
console.log(Boolean([]));
console.log(Boolean(function () {}));
console.log(Boolean(undefined));
console.log(Boolean(null));

console.log(Number("123"));
console.log(Number("a")); //NaN Not a Number
console.log(Number({}));
