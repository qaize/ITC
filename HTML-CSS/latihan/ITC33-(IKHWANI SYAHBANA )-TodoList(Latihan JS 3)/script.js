let highestScore = 0;
let score = 0;
let counterGuess = 0;
let min = 0;
let theNumber;
let max;

function getRandomInt(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min) + min); // The maximum is exclusive and the minimum is inclusive
}
max = prompt(" Please insert your max guessing value ");
theNumber = getRandomInt(min, Number(max)) + 1;
function mainLagi() {
  max = prompt(" Please insert your max guessing value ");
  theNumber = getRandomInt(min, Number(max)) + 1;
}

let jumlahTebak = document.querySelector(".guesses");
let form = document.querySelector("form");
let highest = document.querySelector(".highscore");

let currentScore = document.querySelector(".current-score");
let nomor = document.querySelector(".number");
highest.textContent = highestScore;
jumlahTebak.textContent = "0";
currentScore.textContent = "0";
let tebak = document.querySelector(".tebak");
tebak.addEventListener("click", function (event) {
  event.preventDefault();

  let numbeer = document.querySelector(".inputAngka").value;
  let hint = document.querySelector(".hint");

  if (theNumber > numbeer) {
    hint.textContent = "Go Up 📈";
    counterGuess++;
    jumlahTebak.textContent = counterGuess;
    score = ((max - counterGuess) / max) * 100;
    currentScore.textContent = score;
  } else if (theNumber < numbeer) {
    hint.textContent = "Go Down📉";
    counterGuess++;
    jumlahTebak.textContent = counterGuess;
    score = ((max - counterGuess) / max) * 100;
    currentScore.textContent = score;
  } else {
    hint.textContent = "Correct 🎉";
    nomor.textContent = theNumber;
    counterGuess++;
    jumlahTebak.textContent = counterGuess;
    score = ((max - counterGuess + 1) / max) * 100;
    if (score > highestScore) {
      highestScore = score;
      currentScore.textContent = score;
      highest.textContent = score;
      // form.querySelector("input[type=text]").readOnly = true;
    } else {
      currentScore.textContent = score;

      // form.querySelector("input[type=text]").readOnly = true;
    }

    //
  }
  let trybutton = document.querySelector(".try-again");
  trybutton.addEventListener("click", (event) => {
    counterGuess = 0;
    score = 0;
    hint.textContent = "";
    jumlahTebak.textContent = "0";
    currentScore.textContent = "0";
    reset();
  });
});

function reset() {
  mainLagi();
}
