"use strict";

(function () {
  get();
  post();
})();

function get() {
  let getButton = document.querySelector(".get");
  getButton.addEventListener("click", (event) => {
    const actionUrl = "https://jsonplaceholder.typicode.com/users";
    //kita pake AJAX -> XML HTTP Request
    const request = new XMLHttpRequest(); //kita akan request json, tapi namanya XML lmao~
    request.open("GET", actionUrl, true); //false -> SJAX, true -> AJAX
    request.send();

    //http ready state
    //Setiap saat dia statenya ganti
    // request.onreadystatechange = () => {
    //   console.log(
    //     `State : ${request.readyState}, Response Code: ${request.status}`
    //   );

    request.onload = () => {
      const jsonResult = JSON.parse(request.responseText);
      console.log(jsonResult);
    }; //kalo udah 4 state dan 200 status code.. ini tuh sebenernya eventnya ajax
  });
}

function post() {
  let postButton = document.querySelector(".post");
  postButton.addEventListener("click", (event) => {
    const actionUrl = "https://jsonplaceholder.typicode.com/todos";

    //json pake quote, dan ga mungkin punya method
    //kalo mau jadi tanggal harus jadi string dulu sebelum dikirim ke web (kalo mau jadi JSON)
    //number, string, boolean, object
    const htmlBody = {
      userId: 1,
      title: "judul",
      completed: false,
    };
    const jsonInString = JSON.stringify(htmlBody);

    const request = new XMLHttpRequest();
    request.open("POST", actionUrl);
    //kalo perlu json
    request.setRequestHeader("Authorization", "Bearer bla bla bla");
    request.setRequestHeader("Content-Type", "application/json");
    request.send(jsonInString);

    //ON LOAD -> kalo status udah 4
    request.onload = () => {
      console.log(request);
    };
  });
}

function fetchGet() {
  const button = document.querySelector(".get");
  button.addEventListener("click", (event) => {});
}
