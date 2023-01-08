"use strict";
//var, const, let

const i = 1;
let x = "abc";

console.log(typeof i);
console.log(typeof x);
console.log(typeof true);
console.log(typeof {});
console.log(typeof []);
console.log(typeof function test() {});

/**
 * 1. Function bisa dijadikan sebagai expression
 * 2. truthy falsy -> Boolean(0) false.. if(0)
 * 3. Dynamically typed language
 */

//reserved word untuk access modifier
// const private = "ini harusnya ga boleh";

const stringInterpolation = `nilai pertama : ${i} nilai kedua : ${x}`;

console.log(stringInterpolation);

//BEDMAS
//Bracket (), Exponentials ^, Division /, Multiplication *,
//Addition +, Substraction -
console.log(1 + 1 + 1 + "1" + 4 + 2);
console.log("1" + (1 + 1 + 1) + 4);
console.log(2 * 4 + 5);
//                        134         +   6
console.log(Number("1" + (1 + 1 + 1) + 4) + 6);

console.log(Boolean(0)); //false
//if(!Boolean(0))
if (!0) {
  //!false -> true
  console.log("masuk kedalam if condition karena truthy falsey");
}

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

//declarative
console.log("forEach");
array.forEach(function (nilai) {
  console.log(nilai);
});

console.log("bentuk lain dari function expression di JS");
array.forEach((nilai) => {
  console.log(nilai);
});

console.log("bentuk lain dari function expression di JS");

//function cetakNilai(nilai){console.log(nilai)}
//const cetakNilai = function(nilai){console.log(nilai)}
const cetakNilai = (nilai) => {
  console.log(nilai);
};

array.forEach(cetakNilai);

console.log(cetakNilai);

cetakNilai(1);

//bikin fungsi konstan yang bilang "Hello world", ga menampung param
// function helloWorld() {
//   console.log("hello world");
// }

const helloWorld = (nilai) => {
  if (typeof nilai === typeof 0) {
    console.log(`hello world ${nilai}`);
  }
};
// const helloWorld = (nama) => console.log(`hello world ${nama}`);

helloWorld(100);
