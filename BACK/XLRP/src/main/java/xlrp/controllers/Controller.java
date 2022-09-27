package xlrp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import xlrp.entities.*;
import xlrp.service.EntityService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	private EntityService entityService;
	/////////////////////////////////////////////////////////////////AUTENTIFICACION
	@RequestMapping(value="/autentificacion",method=RequestMethod.POST)
	public ResponseEntity<Perfil> iniciarSesion(@RequestBody Perfil perfil_sesion){
		return ResponseEntity.ok(entityService.autentificacion(perfil_sesion));
	}
	/////////////////////////////////////////////////////////////////OBTENER COSAS
	@RequestMapping(value="/perfiles",method=RequestMethod.GET)
	public ResponseEntity<List<Perfil>> getAllPerfiles(){
		return ResponseEntity.ok(entityService.allPerfiles());
	}
	
	//Servicios (error 405).--------------------------------------------------------------
	@RequestMapping(value="/servicios",method=RequestMethod.GET)
	public ResponseEntity<List<Servicio>> getAllServicios(){
		return ResponseEntity.ok(entityService.allServicios());
	}
	@RequestMapping(value="/clientes",method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> getAllClientes(){
		return ResponseEntity.ok(entityService.allClientes());
	}
	/////////////////////////////////////////////////////////////////OBTENER COSAS POR ID FACIL
	@RequestMapping(value="/perfiles/{id}",method=RequestMethod.GET)
	public ResponseEntity<Optional<Perfil>> getPerfil(@PathVariable long id){
		return ResponseEntity.ok(entityService.perfilPorId(id));
	}
	@RequestMapping(value="/servicios/{id_servicio}", method=RequestMethod.GET)
	public ResponseEntity<Optional<Servicio>> PeticionServicios(@PathVariable long id_servicio){
		return ResponseEntity.ok(entityService.servicioPorId_servicio(id_servicio));
	}
	@RequestMapping(value="/clientes/{id_cita}",method=RequestMethod.POST)
	public ResponseEntity<Optional<Cliente>> clientePorId(@PathVariable long id_cita){
		return ResponseEntity.ok(entityService.clientePorId_cita(id_cita));
	}
	/////////////////////////////////////////////////////////////////OBTENER COSAS POR ID DEL PADRE
	@RequestMapping(value="/servicios/profesional/{id_profesional}",method=RequestMethod.GET)
	public ResponseEntity<List<Servicio>> servicioPorId_profesional(@PathVariable long id_profesional){
		return ResponseEntity.ok(entityService.serviciosPorId_profesional(id_profesional));
	}
	@RequestMapping(value="/clientes/servicio/{id_servicio}",method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> clientesPorId_servicio(@PathVariable long id_servicio){
		return ResponseEntity.ok(entityService.clientesPorId_servicio(id_servicio));
	}
	/////////////////////////////////////////////////////////////////OBTENER COSAS POR ID DEL ABUELO
	@RequestMapping(value="/clientes/profesional/{id_profesional}",method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> clientesPorId_profesional(@PathVariable long id_profesional){
		return ResponseEntity.ok(entityService.clientesPorId_profesional(id_profesional));
	}
	/////////////////////////////////////////////////////////////////REGISTRAR COSAS
	@RequestMapping(value="/perfiles/registrar",method=RequestMethod.POST)
	public ResponseEntity<Perfil> registrarse1(@RequestBody Perfil perfil_registro){
		return ResponseEntity.ok(entityService.registrarPerfil(perfil_registro));
	}
	
	//no se como registrar yo desde postman---------------------------------------------
	@RequestMapping(value="/servicios/registrar",method=RequestMethod.POST)
	public ResponseEntity<Servicio> registrarServicio(@RequestBody Servicio servicio_registrado){
		return ResponseEntity.ok(entityService.registrarServicio(servicio_registrado));
	}
	/////////////////////////////////////////////////////////////////EDITAR COSAS
	@RequestMapping(value="/perfiles/editar",method=RequestMethod.POST)
	public ResponseEntity<Optional<Perfil>> editarPerfil(@RequestBody Perfil perfil_editado){
		return ResponseEntity.ok(entityService.editarPerfil(perfil_editado));
	}
	
	//Este no se como comprobar la edicion (error 400)-------------------------------------
	@RequestMapping(value="/servicios/editar",method=RequestMethod.POST)
	public ResponseEntity<Servicio> editarServicio(@RequestBody Servicio servicio_editado){
		return ResponseEntity.ok(entityService.editarServicio(servicio_editado));
	}
	/////////////////////////////////////////////////////////////////ELIMINAR COSAS
	@RequestMapping(value="/perfiles/delete/{id}", method=RequestMethod.DELETE)
	public void deletePerfil(@PathVariable Long id){
		entityService.eliminarPerfilPorId(id);
	}
	@RequestMapping(value="/servicios/delete/{id_servicio}",method=RequestMethod.DELETE)
	public void eliminarServicio(@PathVariable long id_servicio){
		entityService.eliminarPorId_servicio(id_servicio);
	}
	@RequestMapping(value="/clientes/eliminar/{id_cita}",method=RequestMethod.DELETE)
	public void eliminarCliente(@PathVariable long id_cita) {
		entityService.eliminarPorId_cita(id_cita);
	}
	/////////////////////////////////////////////////////////////////BUSCAR COSAS
	@RequestMapping(value="/servicios/buscar/{Keyword}", method=RequestMethod.GET)
	public ResponseEntity<List<Servicio>> serviciosKeyword(@PathVariable String Keyword){
		return ResponseEntity.ok(entityService.serviciosKeyword(Keyword));
	}
}
