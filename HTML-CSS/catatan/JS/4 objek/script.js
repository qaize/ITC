const person = {
  name: "zen",
  bithDate: new Date("1999-01-01"),
  intro: function () {
    console.log(`gue : ${person.name} lahirnya : ${person.bithDate} `);
  },
  buku: {
    author: "aws",
  },
};

let exJson = JSON.parse(`{
    "id": 1,
    "firstname": "qaize",
    "isActive": true,
    "book": {
      "author": "Jordan Peterson",
      "title": "12 Rules Of Life",
      "haveRead": false,
      "lastPage": 127,
      "onProgress": true
    }
  }
  `);

console.log(JSON.stringify(exJson));
