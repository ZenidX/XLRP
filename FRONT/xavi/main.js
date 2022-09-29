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
const api_clie_clie=api+'clientes/cliente/';

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

// RECARGA DE INFORMACION SEGÚN TIPO DE PAGINA
if(localStorage.getItem('page')=='perfil'){
    getJSON(api_serv_prof+id_profesional).then(json=>{
        for(let json_ele in json){
            document.getElementById("titular").innerHTML = json[i].titular;
            document.getElementById("descripcion").innerHTML = json[i].descripcion;
        }
    })
    getJSON(api_serv_clie)
}else if(localStorege.getItem('page')=='buscador'){
    getJSON(api_serv).then(json=>{
    })
}
