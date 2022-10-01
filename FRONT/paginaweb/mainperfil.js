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

/*Necesitar una id en localStorage para entrar en perfil y creacion*/
if(!localStorage.getItem("id")){
    alert("Debes iniciar sesión o registrarte para acceder a tu perfil.");
    window.location.href="http://127.0.0.1:5500/FRONT/paginaweb/index.html"
}

/*Cerrar sesión*/
function cerrar(){
    localStorage.removeItem("id");
    window.location.href = 'http://127.0.0.1:5500/FRONT/paginaweb/index.html';
}

/*Método para editar el perfil directamente desde la base de datos de forma personalizada*/
getJSON(api_perf+localStorage.getItem('id')).then(json_perfil=>{
    document.getElementById("name").innerHTML=json_perfil.nombre;
    document.getElementById("lastname").innerHTML=json_perfil.apellidos;
    document.getElementById("titular").innerHTML=json_perfil.titular;
    if(json_perfil.edad>1){
    document.getElementById("edad").innerHTML=json_perfil.edad;
    }
    document.getElementById("email").innerHTML=json_perfil.email;
    document.getElementById("municipio").innerHTML=json_perfil.municipio;
    document.getElementById("cp").innerHTML=json_perfil.cp;
    document.getElementById("telefono").innerHTML=json_perfil.telefono;
})

/*Editar el perfil*/
function cancelar() {
    location.reload();
}
function editarperfil(){
    document.querySelectorAll(".profile_description").forEach(function(el) {
        el.style.display="none"
    });
    const botones_edicion=document.getElementById("botones_edicion");
    const forEdi = document.getElementById("formularioEdicion");
    const cancelar=document.getElementById("cancelar")
    forEdi.style.display="block";
    botones_edicion.style.display='none';
    cancelar.style.display="block"
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
    forEdi.onsubmit = async (e) => {
        e.preventDefault();
        const pepito = (new FormData(forEdi)).entries();
        var JSON =`{"id":"${localStorage.getItem("id")}",`;
        for (var pair of pepito) {
            JSON=JSON+'"'+pair[0]+'"'+':'+'"'+pair[1]+'"'+',';
        }
        JSON=JSON.substring(0,JSON.length-1)+'}';
        postJSON(api_perf_edit,JSON).then((result)=>{
            console.log(result)
        })
        window.location.href ='http://127.0.0.1:5500/FRONT/paginaweb/perfil.html'
    };
    getJSON(api_perf+localStorage.getItem("id")).then(json_perfil =>{
        document.getElementsByName("nombre")[0].value=json_perfil.nombre;
        document.getElementsByName("apellidos")[0].value=json_perfil.apellidos;
        document.getElementsByName("email")[0].value=json_perfil.email;
        document.getElementsByName("contraseña")[0].value=json_perfil.contraseña;
        if(json_perfil.edad>0){
            document.getElementsByName("edad")[0].value=json_perfil.edad;
        }
        document.getElementsByName("titular")[0].value=json_perfil.titular;
        document.getElementsByName("municipio")[0].value=json_perfil.municipio;
        document.getElementsByName("cp")[0].value=json_perfil.cp;
        document.getElementsByName("telefono")[0].value=json_perfil.telefono;
    })
}

/*Mostrar los servicios añadidos*/
getJSON(api_serv_prof+localStorage.getItem("id")).then(json_servicio=>{
    console.log(json_servicio[1])
    for(let i=0;i<json_servicio.length;i++){
        a=String("titulo_"+`${i+1}`)
        console.log(a)
        b=String("servicio_"+`${i+1}`)
        console.log(b)
        console.log(typeof b)
        document.getElementById(b).style.display="block";
        document.getElementById(a).innerHTML=json_servicio[i].titular;
        document.getElementById(a).onclick= function servicio() {
            console.log(json_servicio[i].id_servicio)
            localStorage.setItem("id_servicio", json_servicio[i].id_servicio)
            window.location.href='http://127.0.0.1:5500/FRONT/paginaweb/resultadoespecifico.html'
        }
    }
});

/*Añadir servicio desde el perfil*/
function anadir(){
    window.location.href='http://127.0.0.1:5500/FRONT/paginaweb/creacion.html'
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

/*Intentar guardar la foto el localstorage*/
/*function getBase64Image(img) {
    var canvas = document.createElement("canvas");
    canvas.width = img.width;
    canvas.height = img.height;
    var ctx = canvas.getContext("2d");
    ctx.drawImage(img, 0, 0);
    var dataURL = canvas.toDataURL("image/png");
    return dataURL.replace(/^data:image\/(png|jpg);base64,/, "");

}
const cambio=document.getElementById("cambio")
cambio.onclick = function hola() {
    bannerImage = document.getElementById('file');
    imgData = getBase64Image(bannerImage);
    localStorage.setItem("foto", imgData);
}*/