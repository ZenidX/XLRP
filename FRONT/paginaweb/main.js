/*Eventos de formularios de inicio de sesión y registro*/
    /*Validación de formularios*/
    (() => {'use strict'
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.querySelectorAll('.needs-validation')
        // Loop over them and prevent submission
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated')
            }, false)
        })
    })()
    /*Limpieza de inputs cuando se sale de los formularios*/
    const iniBTN = document.getElementById("iniciar-sesion");
    const forInicio = document.getElementById("formularioInicio");
    iniBTN.addEventListener("click", limpiarFormulario);
    const regBTN = document.getElementById("registro");
    const forReg = document.getElementById("formularioRegistro");
    regBTN.addEventListener("click", limpiarFormulario);
    function limpiarFormulario(){
        forInicio.reset();
        forReg.reset();
    }
    /*Limpieza de validaciones cuando se sale de los formularios*/
    iniBTN.addEventListener("click", myFunction);
    regBTN.addEventListener("click", myFunction);
    function myFunction() {
        if(forInicio.classList.contains("was-validated")){
            forInicio.classList.remove("was-validated");
        }
        if(forReg.classList.contains("was-validated")){
            forReg.classList.remove("was-validated");
        }
    }

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

/* Funcionalidad del registro a través de JSON*/
formularioRegistro.onsubmit = async (e) => {
    e.preventDefault();
    const pepito = (new FormData(formularioRegistro)).entries();
    // Para ver que se haya creado el formData correctamente
    var JSON ='{';
    for (var pair of pepito) {
        JSON=JSON+pair[0]+ ':' + pair[1]+','; 
    }
    console.log(JSON);
    JSON=JSON.substring(0,JSON.length-1)+'}';
    console.log(JSON);
    let response = await fetch('http://localhost:8080/api/perfiles/registrar', {
        method: 'POST',
        body: JSON,
        headers: {"Content-type": "application/json; charset=UTF-8"}
    });

    let result = await response.json();
    console.log(result);
    alert(result.message);
};

function cancelar() {
    location.reload();
}
function aceptar() {
    
}
function editarperfil(){
    const editarperfil=document.getElementById("editarperfil");
    const botones_edicion=document.getElementById("botones_edicion")
    var foto_creador=document.getElementById("foto_creador");
    foto_creador.innerHTML='<input type="file" id="file" accept="image/*" style="cursor: pointer">'
    editarperfil.textContent='Aceptar'
    editarperfil.onclick="aceptar()"
    botones_edicion.insertAdjacentHTML("beforeend", '<button class="text-dark" id="cancelar" onclick="cancelar()">Cancelar</button>')
}

/* Llamar a servicios desde el buscador*/
async function fetchJSON(url1) {
    const response = await fetch(url1);
    const jsonResponse = await response.json();
    return jsonResponse;
}
var id_servicio=1;
var url_servicios = 'http://localhost:8080/api/servicios/';
var url_profesionales='http://localhost:8080/api/perfiles/';
fetchJSON(url_servicios+id_servicio).then(json => {
    console.log(json)
    document.getElementById("serdes").innerHTML = json.descripcion;
    fetchJSON(url_profesionales+json.id_profesional).then(json_prof=>{
    console.log(json_prof);
    document.getElementById("nombre_profesional").innerHTML = json_prof.nombre+' '+json_prof.apellidos;
})})

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