"use strict";

(function () {
  menambahkanNilaiDiInputForm();
  addSearchEvent();
})();

function perkenalanDom() {
  console.log(document);

  console.log(document.body);

  console.log(document.querySelector("div"));
  const documentNodes = document.querySelectorAll("div");

  const divPertama = documentNodes[0];
  const divKedua = documentNodes[1];

  divPertama.textContent = "Ini ditambahinnya dari javascript";
  console.log(divPertama);
  console.log(divKedua);
}

//nambahin nilai ke form
function menambahkanNilaiDiInputForm() {
  const searchInput = document.querySelector(".search-form > input");
  searchInput.value = "test";
  console.log(searchInput.value);
}
//attribute (html) (udah)
//mengoprek element (CRUD)

//nambahin event
function addSearchEvent() {
  const searchForm = document.querySelector(".search-form");
  const searchButton = searchForm.querySelector("input[type=submit]");

  searchForm.addEventListener("keypress", function (event) {
    event.preventDefault();
  });

  // searchButton.addEventListener("click", function (event) {
  //   event.preventDefault();
  // });

  searchButton.addEventListener("dblclick", function (event) {
    alert(searchForm.querySelector("input[type=text]").value);
  });
}
