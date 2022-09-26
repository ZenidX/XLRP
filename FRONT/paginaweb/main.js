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

/* Llamar a servicios desde el buscador*/
async function fetchJSON(url1) {
    const response = await fetch(url1);
    const jsonResponse = await response.json();
    return jsonResponse;
}

const api='http://localhost:8080/api'
const api_autentificacion='http://localhost:8080/api/autentificacion';
const api_perf='http://localhost:8080/api/perfiles/';
const api_perf_regi='http://localhost:8080/api/perfiles/registrar';
const api_perf_edit='http://localhost:8080/api/perfiles/editar';
const api_serv='http://localhost:8080/api/servicios/';
const api_serv_regi='http://localhost:8080/api/servicios/registrar';
const api_serv_prof='http://localhost:8080/api'
const api_clie='http://localhost:8080/api/clientes/';
/*
fetchJSON(url_servicios+id_servicio).then(json_servicio => {
    document.getElementById("servicio_descripcion").innerHTML = json_servicio.descripcion;
    document.getElementById("servicio_titular").innerHTML     = json_servicio.titular;
    document.getElementById("servicio_tarifa").innerHTML      = json_servicio.tarifa;
    document.getElementById("servicio_horario").innerHTML     = json_servicio.horario;
    fetchJSON(url_perfiles+json_servicio.id_profesional).then(json_profesional=>{
    document.getElementById("nombre_profesional").innerHTML = json_profesional.nombre+' '+json_profesional.apellidos;
    document.getElementById("nombre_profesional").innerHTML = json_profesional.nombre+' '+json_profesional.apellidos; 
})});
*/
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



/*Editar el perfil*/
function cancelar() {
    location.reload();
}
function aceptar() {
    const botones_edicion=document.getElementById("botones_edicion");
    botones_edicion.innerHTML='<button class="text-dark" id="editar_perfil" onclick="editarperfil()">Editar perfil</button>'
}
function editarperfil(){
    const botones_edicion=document.getElementById("botones_edicion");
    const editar_perfil=document.getElementById("editar_perfil");
    editar_perfil.textContent='Aceptar'
    editar_perfil.setAttribute('onclick', 'aceptar()')
    botones_edicion.insertAdjacentHTML("afterbegin",'<input type="file" id="file" accept=".png, .jpg, .jpeg">')
    botones_edicion.insertAdjacentHTML("afterbegin",'<label for="file">Selecciona una foto de perfil:</label>')
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
    fetchJSON(api_perf).then(json_perfil => {
        document.getElementById("name").innerHTML = json_perfil[0].nombre;
        document.getElementById("lastname").innerHTML = json_perfil[0].apellidos;
        document.getElementById("email").innerHTML = json_perfil[0].email;
        document.getElementById("edad").innerHTML = json_perfil[0].edad;
        document.getElementById("titular").innerHTML = json_perfil[0].titular;
        document.getElementById("municipio").innerHTML = json_perfil[0].municipio;
        document.getElementById("cp").innerHTML = json_perfil[0].cp;
        document.getElementById("telefono").innerHTML = json_perfil[0].telefono;
        console.log(json_perfil)
    })
    
}




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