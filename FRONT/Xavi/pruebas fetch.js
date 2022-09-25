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
    document.getElementById("serdes").innerHTML = json.descripcion;
    console.log("Hemos cambiado la descripcion con el json del servicio");
    return json.id_profesional;
}).then(id_profesional=>{
    json_prof=fetchJSON(url_profesionales+id_profesional);
    document.getElementById("nombre_profesional").innerHTML = json_prof.nombre+' '+json_prof.apellidos;
    console.log("Hemos cambiado el nombre y apellidos con el json del profesional que ponia en el json del servicio");
})