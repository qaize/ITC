// date manipulation
const dateNow = new Date();
console.log(`
hari :    ${dateNow.getDay()}
tanggal : ${dateNow.getDate()}
bulan : ${dateNow.getMonth() + 1}
tahun : ${dateNow.getFullYear()}
`);

// Array

const daftar = ["K", 2, 3, 4, 5];

// insert value baru dari indeks terakhir
daftar.push("a");
// insert value baru dari indeks pertama
daftar.unshift(2);
// read
daftar[0];

// update
daftar[0] = "b";

// menghapus values indeks array terakhir
daftar.pop();
// menghapus values indeks array awal
daftar.shift();

for (let index in daftar) {
  console.log(index);
}

// memecah berdasarkan value
for (let values of daftar) {
  console.log(values);
}

// function
//foreach menggunakan function
console.log("anoymous function");
daftar.forEach(function (n) {
  console.log(n);
});

const namafunction = function (n) {
  console.log(n);
};

daftar.forEach(namafunction);
daftar.forEach((nilai) => console.log(nilai));
