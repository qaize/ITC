"use strict";

//JS normal object
let employee = {
  firstName: "Aqira",
  lastName: "Kelana",
  birthDate: new Date(),
  isActive: true,
  perkenalanDiri: function () {
    console.log(`${this.firstName} ${this.lastName}`);
  },
};

//JSON
let jsonObject = JSON.parse(`{
  "firstName": "Aqira",
  "lastName": "Kelana",
  "birthDate": "1991/01/01",
  "roomNumber": 1
}`);

console.log(jsonObject);

console.log(JSON.stringify(employee));
