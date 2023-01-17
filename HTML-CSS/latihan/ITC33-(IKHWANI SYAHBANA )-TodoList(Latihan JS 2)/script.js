"use strict";

let submitButton = document.querySelector(".submitNya");
submitButton.addEventListener("click", (event) => {
  event.preventDefault();
  let buttondelete = document.createElement("button");
  let listhari = document.querySelector("select").value;
  let textTodo = document.querySelector(".textTodo").value;

  if (textTodo == "") {
    alert("Data tidak boleh kosong");
  } else {
    let input = document.querySelector("." + listhari);
    let todolist = document.createElement("div");
    buttondelete.textContent = "✔️";
    todolist.textContent = textTodo;
    todolist.append(buttondelete);
    todolist.classList.add("todo");
    input.append(todolist);
    document.querySelector("form").reset();

    buttondelete.addEventListener("click", function () {
      todolist.remove();
    });
  }
});
