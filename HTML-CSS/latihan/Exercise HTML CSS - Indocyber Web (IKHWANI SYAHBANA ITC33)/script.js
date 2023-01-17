"use strict";

let listKandidat = [];
let parseData = JSON.parse(localStorage.getItem("daftarKandidat"));
let refresh = document.querySelector(".refresh");
let buttonAdd = document.querySelector(".tambahin");
buttonAdd.addEventListener("click", function () {
  // event.defaultPrevented();
  let inputNama = document.querySelector(".nama").value;
  let inputPhone = Number(document.querySelector(".phone").value);
  let inputEmail = document.querySelector(".email").value;
  let inputDomisili = document.querySelector(".domisili").value;
  let inputUniversity = document.querySelector(".univ").value;

  if (parseData == null) {
    listKandidat.push(
      objectMaker(
        inputNama,
        inputPhone,
        inputEmail,
        inputDomisili,
        inputUniversity
      )
    );
  } else {
    listKandidat = parseData;
    listKandidat.push(
      objectMaker(
        inputNama,
        inputPhone,
        inputEmail,
        inputDomisili,
        inputUniversity
      )
    );
  }
  localStorage.setItem("daftarKandidat", JSON.stringify(listKandidat));
});

function objectMaker(nama, phone, email, domisili, university) {
  let z = {
    name: nama,
    phone: phone,
    email: email,
    domsili: domisili,
    university: university,
  };

  return z;
}

for (const key in JSON.parse(localStorage.getItem("daftarKandidat"))) {
  const tr = document.createElement("tr");
  const mhsBaru = document.querySelector("tbody");
  const tdNama = document.createElement("td");
  const tdNomer = document.createElement("td");
  const tdemail = document.createElement("td");
  const tddomicile = document.createElement("td");
  const tdUniv = document.createElement("td");
  const tdAction = document.createElement("td");
  const aDel = document.createElement("a");
  const aEdit = document.createElement("a");
  const ButtonEdit = document.createElement("button");
  const ButtonDelete = document.createElement("button");
  const iaDel = document.createElement("i");
  const iaEdit = document.createElement("i");
  ButtonEdit.append(iaEdit);
  ButtonDelete.append(iaDel);
  aEdit.append(ButtonEdit);
  aDel.append(ButtonDelete);
  tdAction.append(aEdit);
  tdAction.append(aDel);
  mhsBaru.append(tr);
  tdNama.textContent = parseData[key].name;
  tdNomer.textContent = parseData[key].phone;
  tdemail.textContent = parseData[key].email;
  tddomicile.textContent = parseData[key].domsili;
  tdUniv.textContent = parseData[key].university;
  ButtonEdit.classList.add("buttonEdit");
  ButtonDelete.classList.add("buttonDelete");
  aDel.classList.add("delete");
  aEdit.classList.add("Edit");
  iaDel.classList.add("fas");
  iaDel.classList.add("fa-hammer");
  iaEdit.classList.add("fas");
  iaEdit.classList.add("fa-angry");
  tr.append(tdNama);
  tr.append(tdNomer);
  tr.append(tdemail);
  tr.append(tddomicile);
  tr.append(tdUniv);
  tr.append(tdAction);

  let deleteList = document.querySelector(".delete");
  deleteList.addEventListener("click", (event) => {
    // event.preventDefault();
    listKandidat = parseData;
    listKandidat.splice(key, 1);
    localStorage.setItem("daftarKandidat", JSON.stringify(listKandidat));
    listKandidat = parseData;
    location.reload();
  });
}
