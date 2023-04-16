const warning = document.getElementById("warning");

const params = new Proxy(new URLSearchParams(window.location.search), {
    get: (searchParams, prop) => searchParams.get(prop),
});

let err = params["error"];

if (err) {
    warning.style.display = "flex";
}