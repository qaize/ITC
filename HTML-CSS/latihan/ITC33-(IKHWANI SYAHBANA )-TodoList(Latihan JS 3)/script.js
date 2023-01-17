let highestScore = 0;
let score = 0;
let counterGuess = 0;
let min = 0;
let theNumber;
let max;
let numbeer;
let list = [];
function getRandomInt(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min) + min); // The maximum is exclusive and the minimum is inclusive
}
mainLagi();
theNumber = getRandomInt(min, Number(max)) + 1;
function mainLagi() {
  max = prompt(" Please insert your max guessing value ");
  if (max == null || max.trim() == "") {
    alert("nilai tidak boleh null!");
    mainLagi();
  }
}
theNumber = getRandomInt(min, Number(max)) + 1;
let jumlahTebak = document.querySelector(".guesses");
let form = document.querySelector("form");
let highest = document.querySelector(".highscore");

let currentScore = document.querySelector(".current-score");
let nomor = document.querySelector(".number");
highest.textContent = highestScore;
jumlahTebak.textContent = "0";
currentScore.textContent = "0";
let tebak = document.querySelector(".tebak");

let hint = document.querySelector(".hint");
tebak.addEventListener("click", function (event) {
  event.preventDefault();
  numbeer = Number(document.querySelector(".inputAngka").value);
  console.log(numbeer);
  if (numbeer == null || numbeer == "") {
    alert("Nilai tidak boleh kosong");
  } else if (numbeer > max || numbeer < 0) {
    alert("masukan nilai antara 1 - " + max);
  } else if (list.includes(numbeer)) {
    alert("Anda sudah menginputkan nilai ini");
  } else {
    if (theNumber > numbeer) {
      hint.textContent = "Go Up 📈";
      counterGuess++;
      list.push(numbeer);
      jumlahTebak.textContent = counterGuess;
      score = ((max - counterGuess) / max) * 100;
      currentScore.textContent = Math.ceil(score);
    } else if (theNumber < numbeer) {
      hint.textContent = "Go Down📉";
      list.push(numbeer);
      counterGuess++;
      jumlahTebak.textContent = counterGuess;
      score = ((max - counterGuess) / max) * 100;
      currentScore.textContent = Math.ceil(score);
    } else if (counterGuess == max) {
      if (confirm("Sesi berakhir, silahkan coba lagi")) {
      }
    } else {
      hint.textContent = "Correct 🎉";
      nomor.textContent = theNumber;
      counterGuess++;
      jumlahTebak.textContent = counterGuess;
      score = ((max - counterGuess + 1) / max) * 100;
      document.querySelector("form").reset();
      document.querySelector(".inputAngka").readOnly = true;
      document.querySelector("input[name=sub]").style.visibility = "hidden";

      if (score > highestScore) {
        highestScore = Math.ceil(score);
        currentScore.textContent = Math.ceil(score);
        highest.textContent = highestScore;
        // form.querySelector("input[type=text]").readOnly = true;
      } else {
        currentScore.textContent = Math.ceil(score);

        // form.querySelector("input[type=text]").readOnly = true;
      }
    }
  }
});

let trybutton = document.querySelector(".try-again");
trybutton.addEventListener("click", (event) => {
  list = [];
  counterGuess = 0;
  score = 0;
  document.querySelector(".guesses").textContent = "0";
  document.querySelector(".hint").textContent = "-";
  document.querySelector(".current-score").textContent = "0";
  document.querySelector("form").reset();
  document.querySelector(".number").textContent = "?";
  document.querySelector(".inputAngka").readOnly = false;
  document.querySelector("input[name=sub]").style.visibility = "visible";
  mainLagi();
});
