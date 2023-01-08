//Control Flow

// If Else / Switch
// Looping
// jump statement (break, continue, return)

const lampuLaluLintas = "merah";
const taatPeraturan = false;
const adaPolisi = false;

switch (lampuLaluLintas) {
  case "hijau":
    console.log("melaju");
    break;
  case "kuning":
    console.log("hati-hati");
    break;
  case "merah":
    if (!taatPeraturan && adaPolisi) {
      console.log("di tilang");
    } else if (!taatPeraturan && !adaPolisi) {
      console.log("menabrak");
    } else {
      console.log("berhenti");
    }
    break;
  default:
    console.log("bukan lampu lalu lintas");
    break;
}

console.log(1 == 1);
console.log("1" === 1);

//truthy falsey
if (!0) {
  console.log("masuk");
}

if (!"") {
  console.log("masuk");
}
