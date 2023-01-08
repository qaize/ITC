"use strict";

(function () {
  get();
  post();
})();

function get() {
  let getButton = document.querySelector(".get");
  getButton.addEventListener("click", (event) => {
    const actionUrl = "https://jsonplaceholder.typicode.com/users";
    const request = new XMLHttpRequest();
    request.open("GET", actionUrl);
    request.send();

    request.onreadystatechange = () => {
      console.log(
        `State : ${request.readyState}, Response Code: ${request.status}`
      );
    };
    request.onload = () => {
      const jsonResult = JSON.parse(request.responseText);
      console.log(jsonResult);
    }; //kalo udah 4 state dan 200 status code.. ini tuh sebenernya eventnya ajax
  });
}

function post() {
  const htmlBody = {
    userId: 1,
    title: "judul",
    completed: false,
  };
  const convertedToJson = JSON.stringify(htmlBody);

  let postButton = document.querySelector(".post");
  postButton.addEventListener("click", (event) => {
    const actionUrl = "https://jsonplaceholder.typicode.com/todos";
    const request = new XMLHttpRequest();
    request.open("POST", actionUrl);

    //kalo perlu buat security
    request.setRequestHeader("Authorization", "Bearer bla bla bla");
    request.setRequestHeader("Content-Type", "application/json");

    request.send(convertedToJson);

    request.onreadystatechange = () => {
      console.log(
        `State : ${request.readyState}, Response Code: ${request.status}`
      );
    };

    //ON LOAD -> kalo status udah 4
    request.onload = () => {
      console.log(request);
    };
  });
}
