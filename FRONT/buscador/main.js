/*FUNCIONES DE PRUEBA*/
/* function buscar() {
    var search=document.getElementById("search").value;
    resultados.innerHTML=search;
}
*/
/* Funcion que te lleva a una página u otra */
function cambiar(){
    var select = document.getElementById('seleccionar');
    var valor = select.selectedIndex;
    if (select.options[valor].value=="Actividades"){
        var formsearch = document.getElementById("form-search");
        formsearch.setAttribute("action", "./resultadosac.html");
    }
    if (select.options[valor].value=="Cursos"){
        var formsearch = document.getElementById("form-search");
        formsearch.setAttribute("action", "./resultadoscu.html");
    }
    if (select.options[valor].value=="Servicios"){
        var formsearch = document.getElementById("form-search");
        formsearch.setAttribute("action", "./resultadosse.html");
    }
}

/* Menú de navegación con jQuery*/
$(".menu-toggle-btn").click(function(){
    $(this).toggleClass("fa-times");
    $(".navigation-menu").toggleClass("active");
});

/* Cambio de foto de fondo */
var header = $('body');

var backgrounds = new Array(
    'url(https://images2.alphacoders.com/238/238870.jpg)', 
    'url(https://www.gratistodo.com/wp-content/uploads/2022/08/Surf-fondos-de-pantalla-1.jpg)',
    'url(https://wallpaper.dog/large/20553364.jpg)',
    'url(https://wallpaperaccess.com/full/2491123.jpg)'
);
    
var current = 0;

function nextBackground() {
    current++;
    current = current % backgrounds.length;
    header.css('background-image', backgrounds[current]);
}
setInterval(nextBackground, 6000);

header.css('background-image', backgrounds[0]);

/* Funcionalidad de estilo del inicio sesión y registro*/
var boton_inicio = document.getElementById("exampleModalLabel");
var boton_registro = document.getElementById("registrarselabel");

boton_inicio.addEventListener("click", reseteo);
boton_registro.addEventListener("click", reseteo);

function reseteo(){
    form.needs-validation;
}

/* Funcionalidad del registro*/
const nombre = document.getElementById("nombre");
const apellidos = document.getElementById("apellidos");
const password = document.getElementById("password");
const emailRegister = document.getElementById("emailRegister");

async function registrar(ev, data){
    ev.preventDefault();
    data = $(data).serialize();
    const string = $('form').attr('action').split('/')[5];
    if(string == 'registrar') action = 'POST';
    const res = await fetch(`http://${ip}:${puerto}/api/pedidos/${string}`, {
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        },
        method: `${action}`
    }); 
    const jsonData = await res.json();
    return jsonData;
}
console.log(registrar())

/* Llamar a servicios desde el buscador*/
async function fetchJSON(url) {
    const response = await fetch(url);
    const jsonResponse = await response.json();
    return jsonResponse;
} 

const url = 'http://localhost:8080/api/servicios'

fetchJSON(url).then(json => {
    document.getElementById("serdes").innerHTML = json[0].descripcion;
    console.log("Adios");
});

/* Llamar API y json*/
/*async function fetchJSON(url) {
    const response = await fetch(url);
    const jsonResponse = await response.json();
    console.log("se esta ejecutando el fetchMoviesJSON")
    return jsonResponse;
} 

const url = 'https://api.chucknorris.io/jokes/random'

fetchJSON(url).then(json => {
    document.getElementById("chuck").innerHTML = json.value;
    console.log("se esta ejecutando el extra para el fecthMoviesJSON suelto")
});

function cambio() {
    fetchJSON().then(json => 
        {document.getElementById("chuck").innerHTML = json.value;
        console.log("se esta haciendo un cambio");
    });
}*/