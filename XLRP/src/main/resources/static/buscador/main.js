var resultados=document.getElementById("resultados");
function buscar() {
    var search=document.getElementById("search").value;
    resultados.innerHTML=search;

}
function cambiar(){
    var select = document.getElementById('seleccionar');
    var valor = select.selectedIndex;
    resultados.innerHTML=select.options[valor].text;
    if (select.options[valor].value=="Actividades"){
        document.getElementById("search").value=select.options[valor].text
    }
}