"use strict";

// state client 0 dan 1
// state server 2 3 4
let pokemon;
(function () {
  // getDataSwapi();
  // getDataApiPoke();
  // getDataLocal();
  postJsonPlaceHolder();
})();

function getDataApiPoke() {
  // unset 0
  const ajax = new XMLHttpRequest();

  //   1
  ajax.open("GET", action() + "pokemon/ditto");
  ajax.send();

  ajax.onreadystatechange = () => {
    console.log(`state : ${ajax.readyState} status : ${ajax.status} `);
  };
  // fungsi load data kalo ready state 4
  ajax.onload = function () {
    console.log(jsonParse(ajax.responseText));
  };
}
function getDataSwapi() {
  // unset 0
  const ajax = new XMLHttpRequest();

  //   1
  ajax.open("GET", "https://swapi.dev/api/people/1/");
  ajax.send();

  ajax.onreadystatechange = () => {
    console.log(`state : ${ajax.readyState} status : ${ajax.status} `);
  };
  // fungsi load data kalo ready state 4
  ajax.onload = function () {
    console.log(jsonParse(ajax.responseText));
    pokemon = jsonParse(ajax.responseText);
  };
}
function action() {
  return "https://pokeapi.co/api/v2/";
}
function getDataLocal() {
  // unset 0
  const ajax = new XMLHttpRequest();

  //   1
  ajax.open("GET", "http://127.0.0.1:5500/data.json");
  ajax.send();

  ajax.onreadystatechange = () => {
    console.log(`state : ${ajax.readyState} status : ${ajax.status} `);
  };
  // fungsi load data kalo ready state 4
  ajax.onload = function () {
    ajax.responseText;
  };
}
function action() {
  return "https://pokeapi.co/api/v2/";
}
function jsonParse(set) {
  return JSON.parse(set);
}

function postJsonPlaceHolder() {
  const ajax = new XMLHttpRequest();

  ajax.open("POST", "https://jsonplaceholder.typicode.com/todos");
  const todo = {
    userId: 1,
    title: "lorem kita",
    completed: true,
  };

  ajax.setRequestHeader("content-Type", "application/json");

  ajax.send(JSON.stringify(todo));

  ajax.onload = function () {
    console.log(this.responseText);
  };
}
