"use strict";
//mengoprek element (CRUD)
/**
 * 1a. Membuat sebuah elemen
 * 1b. Remove elemennya dari keberadaan
 * 1c. Menambahkan elemen child ke parent
 *
 * 2. Menambahkan attribute dan valuenya.
 */

(function () {
  membuatElemen();
})();

function membuatElemen() {
  const body = document.querySelector("body");

  //membuat elemen
  const divSementara = document.createElement("div");

  //menambahkan div baru kedalam body
  const main = document.createElement("main");
  body.append(divSementara, main);

  menghapusElemen(divSementara);
  const divBaru = menambahkanChildElement(main);
  menambahkanAttribute(divBaru);
}

function menghapusElemen(elemen) {
  elemen.remove();
}

function menambahkanChildElement(parent) {
  //buat elemen
  const divBaru = document.createElement("div");
  divBaru.textContent = "Ini adalah box";

  //menambahkan child span
  const span = document.createElement("span");
  divBaru.append(span);
  //menambahkan child button
  const button = document.createElement("button");
  button.textContent = "✔";
  divBaru.append(button);
  //menyisipkan i diantara span dan button

  // span.after(document.createElement("i"));
  divBaru.insertBefore(document.createElement("i"), button);
  parent.append(divBaru);

  return divBaru;
}

function menambahkanAttribute(elemen) {
  elemen.setAttribute("id", "box-1");

  elemen.setAttribute("class", "box");
  //el akan mengoverride box
  elemen.setAttribute("class", "el");

  elemen.classList.add("box");
  elemen.classList.add("kotak");
  elemen.classList.remove("kotak");
}
