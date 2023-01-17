"use strict";
// select body

let buttonAdd = document.querySelector(".add");
buttonAdd.addEventListener("click", function (event) {
  // event.defaultPrevented();
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
  aEdit.append(ButtonDelete);
  tdAction.append(aEdit);
  tdAction.append(aDel);

  mhsBaru.append(tr);
  tdNama.textContent = "nama";
  tdNomer.textContent = "0111";
  tdemail.textContent = "nama@asd";
  tddomicile.textContent = "mataram";
  tdUniv.textContent = "unram";
  ButtonEdit.classList.add("buttonEdit");
  ButtonDelete.classList.add("buttonDelete");
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
});
