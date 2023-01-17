"use script";
// window.localStorage.clear();
// json object
//   let counterKey = 0;
let setButton = document.querySelector(".set");
let getButton = document.querySelector(".get");
let removeButton = document.querySelector(".remove");
let clearButton = document.querySelector(".clear");
let refresh = document.querySelector(".refresh");
let inputValue;
let inputKey;
let list = [];
let listKandidat = [];

listKandidat.push({
  id: 1,
  name: "qaize ",
  phoneNumber: "081231284790",
  email: "qaize@gmail.com 1",
  domisili: "Mataram 2",
  university: "Universitas Mataram 2",
});
listKandidat.push({
  id: 2,
  name: "qaize ",
  phoneNumber: "081231284790",
  email: "qaize@gmail.com 1",
  domisili: "Mataram 2",
  university: "Universitas Mataram 2",
});
// let z = {
//   id: 1,
//   name: "qaize ",
//   phoneNumber: "081231284790",
//   email: "qaize@gmail.com 1",
//   domisili: "Mataram 2",
//   university: "Universitas Mataram 2",
// };

localStorage.setItem("Kandidat", JSON.stringify(listKandidat));

setButton.addEventListener("click", (event) => {
  event.preventDefault();
  inputValue = document.querySelector(".val").value;
  inputKey = Number(document.querySelector(".key").value);
  localStorage.setItem(inputKey, inputValue);
});
getButton.addEventListener("click", (event) => {
  event.preventDefault();
  let form = document.querySelector("form");
  form.querySelector("input[name=value]").value =
    localStorage.getItem(inputKey);
});
removeButton.addEventListener("click", (event) => {
  event.preventDefault();
  localStorage.removeItem(inputKey);
});
clearButton.addEventListener("click", (event) => {
  event.preventDefault();
  localStorage.clear();
});
refresh.addEventListener("click", (event) => {
  event.preventDefault();
  location.reload();
});
showTable();
function showTable() {
  for (const bro in localStorage) {
    if (localStorage.hasOwnProperty(bro)) {
      if (!list.includes(key)) {
        let tbodySelec = document.querySelector("tbody");
        let insertRowTable = document.createElement("tr");
        let insertValue = document.createElement("td");
        let insertKey = document.createElement("td");
        insertRowTable.append(insertKey);
        insertRowTable.append(insertValue);
        tbodySelec.append(insertRowTable);
        insertValue.textContent = localStorage.getItem(bro);
        insertKey.textContent = bro;
        list.push(bro);
      } else {
        insertValue.textContent = localStorage.getItem(bro);
        insertKey.textContent = bro;
      }
    }
  }
}
