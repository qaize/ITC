/**
 * local storage + session storage (storages)
 * cookie -> memory paling kecil (untuk setting banyak exclusivity domain, waktu, security, dst..)
 * PWA  -> indexed db + web sql
 *
 * local storage -> kaya map
 *
 * session storage -> 20 menit doang
 *
 *
 *
 * cache storage -> biasanya simpen media
 */

(function () {
  addStorageButtonClicks();
})();

function addStorageButtonClicks() {
  setStorage();
  deleteStorage();
  clearStorage();
  getStorage();
}

function setStorage() {
  const setButton = document.querySelector(".set");
  setButton.addEventListener("click", (event) => {
    const key = document.querySelector(".key").value;
    const value = document.querySelector(".value").value;

    localStorage.setItem(key, value);
    sessionStorage.setItem(key, value);
  });
}

function getStorage() {
  const getButton = document.querySelector(".get");
  getButton.addEventListener("click", (event) => {
    const key = document.querySelector(".key").value;
    document.querySelector(".value").value = localStorage.getItem(key);
  });
}

function clearStorage() {
  const clearButton = document.querySelector(".clear");
  clearButton.addEventListener("click", (event) => {
    localStorage.clear();
  });
}

function deleteStorage() {
  const deleteButton = document.querySelector(".delete");
  deleteButton.addEventListener("click", (event) => {
    const key = document.querySelector(".key").value;
    localStorage.removeItem(key);
  });
}
