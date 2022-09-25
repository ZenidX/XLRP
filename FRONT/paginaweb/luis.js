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