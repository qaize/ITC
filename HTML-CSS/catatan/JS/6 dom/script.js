"use strict";

const listEl = document.querySelectorAll(".el");
const form = document.querySelector("form");
(function main() {
  const divBaru = document.createElement("div");
  divBaru.textContent = "aa";
  const insertButton = document.querySelector(".insert");

  // Memasukan kedalam objek
  insertButton.append(document.createElement("div"));

  //    memasukan objek baru tersebut setelah objek ini
  insertButton.after(divBaru);
  // memasukan objek baru tersebut sebelum objek
  insertButton.before(divBaru);

  insertButton.childNodes;
  insertButton.parentNode;

  const buttonbd = document.createElement("button");

  buttonbd.textContent = "delete me";
  buttonbd.addEventListener("click", (event) => {
    buttonbd.remove();
  });
  insertButton.after(buttonbd);

  //   isiForm();
  //   clearform();
  //   formSumbitEvent();

  //   insertButton;
})();

function cobaDom() {
  // nilai konten ikutan berubah karena sifat dari objek ini adalah reference tipe yang dimana mereferensikan pada objek yang sama

  const listEl = document.querySelectorAll(".el");
  const el = document.querySelector(".el--1");
  // el--1 akan ikut berubah
  //   listEl[0].textContent = "t";
  console.log(listEl);
  console.log(el);
}

function warning() {
  const warn = document.querySelectorAll(".warning");
}

function cobaClassList() {
  //   listEl[0].classList;
  listEl[0].classList.add("baru");
  listEl[0].classList.remove("baru");
  //   menambahkan ID
  listEl[0].id = 1;
}

function ambilParamSearch() {
  const urlFormParams = new URLSearchParams(document.location.search);
  urlFormParams.get("");
  urlFormParams.get("age");
  urlFormParams.get("isActive");
}

function isiForm() {
  const insertButton = document.querySelector(".insert");
  insertButton.addEventListener("click", function (event) {
    const form = document.querySelector("form");
    form.querySelector("input[type=text]").value = "set";
    // form.querySelector("input[type=text]").readOnly = true;
    form.querySelector("input[type=number]").value = 12;
    // form.querySelector("input[type=checkbox]").checked = true;
  });
}
function clearform() {
  const clearButton = document.querySelector(".clear");
  clearButton.addEventListener("click", function (event) {
    const form = document.querySelector("form");
    form.querySelector("input[type=text]").value = "";
    form.querySelector("span]").style.visibility = visibility;
    // form.querySelector("input[type=text]").readOnly = false;
    form.querySelector("input[type=number]").value = null;
    form.querySelector("input[type=checkbox]").checked = false;
  });
}

// function formSumbitEvent() {
//   const urlFormParams = new URLSearchParams(document.location.search);
//   const submitButton = document.querySelector("form > button");
//   submitButton.addEventListener("click", (event) => {
//     alert(`
//   fullname = ${urlFormParams.get("fullname")}
//   age = ${urlFormParams.get("age")}
//   active = ${urlFormParams.get("isActive")}
//   `);
//   });

// }

function formSumbitEvenat() {
  const submitButton = document.querySelector(".sub");
  const urlFormParams = new URLSearchParams(document.location.search);
  submitButton.addEventListener("click", (event) => {
    event.preventDefault();
    if (
      form.querySelector("input[type=text]").value.trim() == "" &&
      form.querySelector("input[type=number]").value.trim() == ""
    ) {
      alert("name dan age null");
    } else if (form.querySelector("input[type=text]").value.trim() == "") {
      form.querySelector("span").style.visibility = "hidden";
      alert("name null");
    } else if (form.querySelector("input[type=number]").value.trim() == "") {
      form.querySelector("span").style.visibility = "hidden";
      alert("age null");
    } else {
      form.querySelector("span").style.visibility = "hidden";
      alert(`
      fullname = ${urlFormParams.get("fullname")}
      age = ${urlFormParams.get("age")}
      active = ${urlFormParams.get("isActive")}
    `);
    }
  });
}

function formSumbitEvent() {
  const submitButton = document.querySelector(".sub");
  submitButton.addEventListener("click", (event) => {
    event.preventDefault();
    const form = document.querySelector("form");
    const warn = document.querySelectorAll("span");
    if (
      form.querySelector("input[type=text]").value.trim() == "" &&
      form.querySelector("input[type=number]").value.trim() == ""
    ) {
    } else if (form.querySelector("input[type=text]").value.trim() == "") {
      form.querySelector("span").style.visibility = "hidden";
    } else if (form.querySelector("input[type=number]").value.trim() == "") {
      form.querySelector("span").style.visibility = "hidden";
    } else {
      form.querySelector("span").style.visibility = "hidden";
    }
  });
}
