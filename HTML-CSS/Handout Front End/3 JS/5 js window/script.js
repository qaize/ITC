"use strict";

//Browser Object Model
const lampuLaluLintas = prompt("Masukkan kondisi lampu sekarang");
const taatPeraturan = confirm("Apakah taat peraturan?");
const adaPolisi = confirm("Apakah ada polisi?");

window.screen;

window.location;
// window.location.reload();
// window.location.assign("https://google.com");

window.setTimeout(function () {
  console.log("udah 5 detik");
}, 5000);

let counter = 1;
const interval = window.setInterval(function () {
  console.log(`berulang ulang ke ${counter++}`);
}, 3000);

//window.clearInterval(interval)
