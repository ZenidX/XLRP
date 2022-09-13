var search=document.getElementById("search");
var resultados=document.getElementById("resultados");
search.oninput= function buscar() {
    resultados.classList.toggle(display)
}