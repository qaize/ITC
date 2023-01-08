(function () {
  const submit = document.querySelector(".form-example > input[type=submit]");

  submit.addEventListener("click", (event) => {
    const myForm = document.querySelector(".form-example");

    window.alert(`
    Name : ${myForm.name.value}
    Gender : ${myForm.gender.value}
    Birth Date : ${myForm.birthDate.value}
    Phone Number : ${myForm.phoneNumber.value}
    Email : ${myForm.email.value}
    Password : ${myForm.password.value}
    Car checked : ${myForm.car.checked}
    Motorcycle checked : ${myForm.motorcycle.checked}
    `);
  });
})();
