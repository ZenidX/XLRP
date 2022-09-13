/*var foto = document.getElementById("foto");
foto.onclick=function cambiar(){
    foto.innerHTML='<p>Buenos días</p>';
};*/
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

