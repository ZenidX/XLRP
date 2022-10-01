/*Endpoints de las api*/
const api='http://localhost:8080/api/';
const api_autentificacion=api+'autentificacion';
const api_perf=api+'perfiles/';
const api_perf_regi=api+'perfiles/registrar';
const api_perf_edit=api+'perfiles/editar';
const api_perf_dele=api+'perfiles/delete'
const api_serv=api+'servicios/';
const api_serv_regi=api+'servicios/registrar';
const api_serv_edit=api+'servicios/editar';
const api_serv_prof=api+'servicios/profesional/';
const api_serv_busc=api+'servicios/buscar/';
const api_clie=api+'clientes/';
const api_clie_regi=api+'clientes/registrar';
const api_clie_edit=api+'clientes/editar';
const api_clie_dele=api+'clientes/delete/';
const api_clie_serv=api+'clientes/servicio/';
const api_clie_prof=api+'clientes/profesional/';

/*Metodos de acceso api*/
async function getJSON(url){
    const response = await fetch(url);
    const jsonResponse = await response.json();
    return jsonResponse;
}
async function postJSON(url,JSON){
    let response = await fetch(url, {
        method: 'POST',
        body: JSON,
        headers: {"Content-type": "application/json; charset=UTF-8"}
    });
    let jsonResponse = await response.json()
    return jsonResponse;
}

/*Inicio de sesión autentificación*/
const forIni = document.getElementById("formularioInicio");
forIni.onsubmit = async function iniciar(e){
    e.preventDefault();
    // Crear un array con los datos del formulario
    const pepito = (new FormData(forIni)).entries();
    // Convertir el array en un JSON
    var JSON ='{';
    for (var pair of pepito) {
        JSON=JSON+'"'+pair[0]+'"'+':'+'"'+pair[1]+'"'+',';
    }
    JSON=JSON.substring(0,JSON.length-1)+'}';
    // Enviar los datos a la base de datos + con el .then que nos devuelva cosas
    postJSON(api_autentificacion,JSON).then((json_id)=>{
        ID_PERFIL=json_id;
        console.log(ID_PERFIL);
        if (ID_PERFIL != -1) {
            localStorage.setItem("id", ID_PERFIL)
            window.location.href = 'http://127.0.0.1:5500/FRONT/paginaweb/perfil.html'
            }
        else {alert("Usuario y/o contraseña incorrecto/s")}
    })
}

/* Funcionalidad del registro a través de JSON*/
const forReg = document.getElementById("formularioRegistro");
forReg.onsubmit = async function hola(e) {
    e.preventDefault();
    // Crear un array con los datos del formulario
    const pepito = (new FormData(forReg)).entries();
    // Convertir el array en un JSON
    var JSON ='{';
    for (var pair of pepito) {
        JSON=JSON+'"'+pair[0]+'"'+':'+'"'+pair[1]+'"'+',';
    }
    JSON=JSON.substring(0,JSON.length-1)+'}';
    // Enviar los datos a la base de datos + con el .then que nos devuelva cosas
    formularioRegistro=document.getElementById("formularioRegistro")
    if (formularioRegistro.checkValidity())
    postJSON(api_perf_regi,JSON).then((json_perfil)=>{
        ID_PERFIL=json_perfil.id;
        console.log(ID_PERFIL);
        localStorage.setItem("id", ID_PERFIL);
        window.location.href = 'http://127.0.0.1:5500/FRONT/paginaweb/perfil.html';
    }); 
};

/*Cambio de header una vez registrado/iniciado*/
if(localStorage.getItem("id")){
    document.getElementById("iniciar-sesion").style.display="none";
    document.getElementById("registro").style.display="none";
    const navegador=document.getElementsByClassName("navigation-menu");
    navegador[0].insertAdjacentHTML("beforeend", '<a href="./perfil.html">Perfil</a><button type="button" id="cerrar-sesion" class="aj_btn" onclick="cerrar()">LOG OUT</button>');
}

/*Cerrar sesión*/
function cerrar(){
    localStorage.removeItem("id");
    window.location.href = 'http://127.0.0.1:5500/FRONT/paginaweb/index.html';
}

/*Mostrar los resultados dependiendo si escribes una palabra o no*/
if(localStorage.getItem("busqueda")){
    getJSON(api_serv_busc+localStorage.getItem("busqueda")).then(json_servicio=>{
    console.log(json_servicio[0]);
    for(let i=0;i<json_servicio.length;i++){
        a=String("titulo_"+`${i+1}`)
        console.log(a)
        b=String("servicio_"+`${i+1}`)
        console.log(b)
        console.log(typeof b)
        document.getElementById(b).style.display="flex";
        document.getElementById(b).style.justifyContent="center";
        document.getElementById(b).style.alignItems="center";
        document.getElementById(a).innerHTML=json_servicio[i].titular;
        document.getElementById(a).onclick= function servicio() {
            console.log(json_servicio[i].id_servicio)
            localStorage.setItem("id_servicio", json_servicio[i].id_servicio)
            window.location.href='http://127.0.0.1:5500/FRONT/paginaweb/resultadoespecifico.html'
        }
    }
})} else {
    getJSON(api_serv).then(json_servicio=>{
        console.log(json_servicio[1])
        for(let i=0;i<json_servicio.length;i++){
            a=String("titulo_"+`${i+1}`)
            console.log(a)
            b=String("servicio_"+`${i+1}`)
            console.log(b)
            console.log(typeof b)
            document.getElementById(b).style.display="flex";
            document.getElementById(b).style.justifyContent="center";
            document.getElementById(b).style.alignItems="center";
            document.getElementById(a).innerHTML=json_servicio[i].titular;
            document.getElementById(a).onclick= function servicio() {
                console.log(json_servicio[i].id_servicio)
                localStorage.setItem("id_servicio", json_servicio[i].id_servicio)
                window.location.href='http://127.0.0.1:5500/FRONT/paginaweb/resultadoespecifico.html'
            }
        }
    });
}

/*Eventos de formularios de inicio de sesión y registro*/
    //Validación de formularios
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
    //Limpieza de inputs cuando se sale de los formularios
    const iniBTN = document.getElementById("iniciar-sesion");
    const forInicio = document.getElementById("formularioInicio");
    iniBTN.addEventListener("click", limpiarFormulario);
    const regBTN = document.getElementById("registro");
    regBTN.addEventListener("click", limpiarFormulario);
    function limpiarFormulario(){
        forInicio.reset();
        forReg.reset();
    }
    //Limpieza de validaciones cuando se sale de los formularios
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

/*Menú de navegación con jQuery*/
$(".menu-toggle-btn").click(function(){
    $(this).toggleClass("fa-times");
    $(".navigation-menu").toggleClass("active");
});

/*Cambio de foto de fondo */
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

/*Funcion que te lleva a una página u otra
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
} */