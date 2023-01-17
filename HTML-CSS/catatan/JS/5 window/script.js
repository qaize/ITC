"use strict";

// let undefined;

// let mistypeVariable;
// mistypeVariable = "set";

(function main() {
  console.log("set");
  times();
})();

function times() {}

function scanner() {
  Window.prompt("");
  window.alert("");
  window.confirm("");
}

function windowProperty() {
  Window.location();
  Window.screen();
}

Window.setTimeout(() => {
  console.log("time out setelah 3 detik");
}, 3000);

function windowFunction() {
  (function () {
    console.log("time out setelah 3 detik");
  },
    3000);

  let counter = 0;

  window.setInterval(function () {
    console.log("interval 3 detik ke " + ++counter);
  }, 3000);
}
