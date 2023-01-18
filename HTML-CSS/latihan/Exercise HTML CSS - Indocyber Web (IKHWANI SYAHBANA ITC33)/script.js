"use strict";

let parseData = JSON.parse(localStorage.getItem("daftarKandidat"));
let listKandidat = [];
let id = "";
// event.defaultPrevented();
(function main() {
  selectData();
})();

function manageData() {
  let inputNama = document.querySelector(".nama").value;
  let inputPhone = Number(document.querySelector(".phone").value);
  let inputEmail = document.querySelector(".email").value;
  let inputDomisili = document.querySelector(".domisili").value;
  let inputUniversity = document.querySelector(".univ").value;
  let data = {
    name: inputNama,
    phone: inputPhone,
    email: inputEmail,
    domisili: inputDomisili,
    university: inputUniversity,
  };
  if (
    inputNama.trim() == "" ||
    inputPhone == 0 ||
    inputEmail.trim() == "" ||
    inputDomisili.trim() == "" ||
    inputUniversity.trim() == ""
  ) {
    alert("fill all the field");
  } else {
    if (id == "") {
      if (parseData == null) {
        listKandidat.push(data);
        localStorage.setItem("daftarKandidat", JSON.stringify(listKandidat));
        // localStorage.clear();
      } else {
        listKandidat = parseData;
        listKandidat.push(data);
        localStorage.setItem("daftarKandidat", JSON.stringify(listKandidat));
        // localStorage.clear();
      }
    }
  }
  localStorage;
}

function selectData() {
  listKandidat = getData();
  if (listKandidat != null) {
    let html = " ";
    let inp = " ";
    let tr;
    let tdNama;
    let tdNomer;
    let tdemail;
    let tddomicile;
    let tdUniv;
    let tdAction;

    for (let key in listKandidat) {
      // tr = document.createElement("tr");
      // tdNama = document.createElement("td");
      // tdNomer = document.createElement("td");
      // tdemail = document.createElement("td");
      // tddomicile = document.createElement("td");
      // tdUniv = document.createElement("td");
      // tdAction = document.createElement("td");
      // tdNama.textContent = listKandidat[key].name;
      // tdNomer.textContent = listKandidat[key].phone;
      // tdemail.textContent = listKandidat[key].email;
      // tddomicile.textContent = listKandidat[key].domsili;
      // tdUniv.textContent = listKandidat[key].university;
      // const aDel = document.createElement("a");
      // const aEdit = document.createElement("a");
      // const ButtonEdit = document.createElement("button");
      // const ButtonDelete = document.createElement("button");
      // const iaDel = document.createElement("i");
      // const iaEdit = document.createElement("i");
      // ButtonEdit.append(iaEdit);
      // ButtonDelete.append(iaDel);
      // aEdit.append(ButtonEdit);
      // aDel.append(ButtonDelete);
      // tdAction.append(aDel, aEdit);

      // ButtonEdit.classList.add("buttonEdit");
      // ButtonDelete.classList.add("buttonDelete");
      // iaDel.classList.add("fas");
      // iaDel.classList.add("fa-hammer");
      // iaEdit.classList.add("fas");
      // iaEdit.classList.add("fa-angry");
      // aDel.classList.add("delete");
      // tr.append(tdNama, tdNomer, tdemail, tddomicile, tdUniv, tdAction);
      // document.getElementById("root").append(tr);

      inp = `<tr><td>${listKandidat[key].name}</td><td>${listKandidat[key].phone}</td><td>${listKandidat[key].email}</td>
      <td>${listKandidat[key].domisili}</td><td>${listKandidat[key].university}</td><td><a href= "javascript:void(0)" onclick="hapus(${key})">hapus</a>
      <a id="myBtn"  href= "javascript:void(0)"  onclick="editData(${key})">Edit</a></td></tr>`;
      html = html + inp;
    }
    document.getElementById("root").innerHTML = html;
  }
}

function editData() {
  // Get the modal
  var modal = document.getElementById("myModal");

  // Get the button that opens the modal
  var btn = document.getElementById("myBtn");

  // Get the <span> element that closes the modal
  var span = document.getElementsByClassName("close")[0];

  // When the user clicks on the button, open the modal
  btn.onclick = function () {
    modal.style.display = "block";
  };

  // When the user clicks on <span> (x), close the modal
  span.onclick = function () {
    modal.style.display = "none";
  };

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function (event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  };
}

function hapus(rid) {
  let listKandidat = getData();
  listKandidat.splice(rid, 1);
  localStorage.setItem("daftarKandidat", JSON.stringify(listKandidat));
  selectData();
}

function getDataLocal() {
  // unset 0
  const ajax = new XMLHttpRequest();
  //   1
  ajax.open("GET", "http://127.0.0.1:5501/data.json");
  ajax.send();
  ajax.onreadystatechange = () => {
    console.log(`state : ${ajax.readyState} status : ${ajax.status} `);
  };
  // fungsi load data kalo ready state 4
  ajax.onload = function () {
    listKandidat = JSON.parse(ajax.responseText);
    localStorage.setItem("daftarKandidat", JSON.stringify(listKandidat));
    selectData();
  };
}

function clearData() {
  localStorage.clear();
  location.reload();
}

function getData() {
  return JSON.parse(localStorage.getItem("daftarKandidat"));
}

// let deleteList = document.querySelector(".delete");
