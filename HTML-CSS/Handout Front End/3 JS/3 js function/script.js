"use strict";
//self - invoking function (invoke === memanggil)
(function () {
  addEvent();
})();

function addEvent() {
  console.log("ini dijalankan");
}

function penjumlahan(nilaiPertama, nilaiKedua) {
  return nilaiPertama + nilaiKedua;
}

function perkalian(nilaiPertama, nilaiKedua, nilaiKetiga = 1) {
  return nilaiPertama * nilaiKedua * nilaiKetiga;
}

function perkenalanDiri(nama = "") {
  if (!nama) {
    console.log("Hello saya tidak ingin memberitahu nama saya..");
  } else {
    console.log(`Hello nama saya ${nama}`);
  }
}

let perhitunganGajiPertahun = (gaji) => {
  return gaji * 12 + gaji * 0.1;
};

perhitunganGajiPertahun = (gaji, lembur) => {
  if (!lembur) {
    return gaji * 12;
  } else {
    return gaji * 12 + lembur * 300_000;
  }
};
