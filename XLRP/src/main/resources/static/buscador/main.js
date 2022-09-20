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
var init = document.getElementById("init");
var inicia = document.getElementById("iniciar");
let interruptor = true;
init.onclick = function iniciar() {
    if(interruptor){
        const para = document.createElement("p");
        para.innerHTML =
        '<div class="col<div class="form-group row"><label for="inputEmail3" class="col-sm-2 col-form-label">Email</label><div class="col-sm-10"><input type="email" class="form-control" id="inputEmail3" placeholder="Email"></div></div><div class="form-group row"><label for="inputPassword3" class="col-sm-2 col-form-label">Password</label><div class="col-sm-10"><input type="password" class="form-control" id="inputPassword3" placeholder="Password"></div></div><div class="form-group row"><div class="col-sm-2">Checkbox</div><div class="col-sm-10"><div class="form-check"><label class="form-check-label"><input class="form-check-input" type="checkbox"> Check me out</label></div></div></div><div class="form-group row"><div class="col-sm-10"><button type="submit" class="btn btn-primary">Sign in</button></div></div>';
        inicia.appendChild(para);
        interruptor = false;
    }
};
var boton_inicio = document.getElementById("exampleModalLabel");
var boton_registro = document.getElementById("registrarselabel");

boton_inicio.addEventListener("click", reseteo);
boton_registro.addEventListener("click", reseteo);

function reseteo(){
    form.needs-validation;
}

/* Funcionalidad del registro*/
