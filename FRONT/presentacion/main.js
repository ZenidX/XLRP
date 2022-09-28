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

//ID del perfil que se arrastrará en todo el JS despues de haberte registrado o iniciado sesións
var ID_PERFIL=0;

// Inicio de sesión autentificación
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
        valor=json_id;
        console.log(valor);
        if (valor != -1) {
            localStorage.setItem("id", valor)
            window.location.href = 'http://127.0.0.1:5500/FRONT/paginaweb/perfil.html'
            }
        else {alert("Error")}
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
    postJSON(api_perf_regi,JSON).then((json_perfil)=>{
        ID_PERFIL=json_perfil.id;
        console.log(ID_PERFIL);
        document.getElementById("name").innerHTML = json_perfil.nombre;
        document.getElementById("lastname").innerHTML = json_perfil.apellidos;
        document.getElementById("email").innerHTML = json_perfil.email;
        /*document.getElementById("edad").innerHTML = json_perfil.edad;
        document.getElementById("titular").innerHTML = json_perfil.titular;
        document.getElementById("municipio").innerHTML = json_perfil.municipio;
        document.getElementById("cp").innerHTML = json_perfil.cp;
        document.getElementById("telefono").innerHTML = json_perfil.telefono;*/
    })
};

/*Editar el perfil*/
function cancelar() {
    location.reload();
}
function aceptar() {
    const botones_edicion=document.getElementById("botones_edicion");
    botones_edicion.innerHTML='<button class="text-dark" id="editar_perfil" onclick="editarperfil()">Editar perfil</button>'
}
function editarperfil(){
    document.querySelectorAll("profile_description")
    const botones_edicion=document.getElementById("botones_edicion");
    botones_edicion.innerHTML='<form action="http://localhost:8080/api/perfiles/editar" method="POST" id="formularioEdicion" onsubmit="registrarse(value, key)"><input type="text" name="nombre" placeholder="Nombre"><input type="text" name="apellidos" placeholder="Apellidos"><input type="text" name="email" placeholder="Email"><input type="text" name="edad" placeholder="Edad"><input type="text" name="titular" placeholder="Titular"><input type="text" name="municipio" placeholder="Municipio"><input type="text" name="cp" placeholder="C.P."><input type="text" name="telefono" placeholder="Teléfono"><label for="file">Selecciona una foto de perfil:</label><input type="file" id="file" name="foto" accept=".png, .jpg, .jpeg"><button type="submit" class="text-dark" id="editar_perfil">Aceptar</button></form>'
    botones_edicion.insertAdjacentHTML("beforeend", '<button class="text-dark" id="cancelar" onclick="cancelar()">Cancelar</button>')
    var file=document.getElementById("file");
    if(file){
        file.addEventListener('change', readURL, true);
        function readURL(){
            const choosedFile = document.getElementById("file").files[0];
            const reader = new FileReader();
            reader.onload = function(){
                document.getElementById('foto_perfil').src = reader.result;
            }
            reader.readAsDataURL(choosedFile)
        }
    }
    const forEdi = document.getElementById("formularioEdicion");
    forEdi.onsubmit = async (e) => {
        e.preventDefault();
        const pepito = (new FormData(forEdi)).entries();
        // Para ver que se haya creado el formData correctamente
        console.log(ID_PERFIL)
        var JSON =`{"id":"${ID_PERFIL}",`;
        for (var pair of pepito) {
            JSON=JSON+'"'+pair[0]+'"'+':'+'"'+pair[1]+'"'+',';
        }
        JSON=JSON.substring(0,JSON.length-1)+'}';
        console.log(JSON)
        postJSON(api_perf_edit,JSON).then((result)=>{
            console.log(result)
        })
        //alert(result.message);
    };
}

/*Codigo para rellenar pagina de servicio*/
/*
getJSON(url_servicios+id_servicio).then(json_servicio => {
    document.getElementById("servicio_descripcion").innerHTML = json_servicio.descripcion;
    document.getElementById("servicio_titular").innerHTML     = json_servicio.titular;
    document.getElementById("servicio_tarifa").innerHTML      = json_servicio.tarifa;
    document.getElementById("servicio_horario").innerHTML     = json_servicio.horario;
    getJSON(url_perfiles+json_servicio.id_profesional).then(json_profesional=>{
    document.getElementById("nombre_profesional").innerHTML = json_profesional.nombre+' '+json_profesional.apellidos;
    document.getElementById("nombre_profesional").innerHTML = json_profesional.nombre+' '+json_profesional.apellidos; 
})});
*/

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