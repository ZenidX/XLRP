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

import xlrp.dao.*;
import xlrp.entities.*;
import xlrp.service.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	private PerfilDAO perfilDAO;
	@Autowired
	private PerfilesService perfilesService;
	@Autowired
	private ServicioDAO servicioDAO;
	@Autowired
	private ServiciosService serviciosService;
	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private ClientesService clientesService;
	@RequestMapping(value="/autentificacion",method=RequestMethod.POST)
	public boolean iniciarSesion(@RequestBody Perfil perfil_sesion){
		return perfilesService.autentificacion(perfil_sesion);
	}
	@RequestMapping(value="/perfiles/registrar",method=RequestMethod.POST)
	public ResponseEntity<Perfil> registrarse1(@RequestBody Perfil perfil_registro){
		return ResponseEntity.ok(perfilesService.registrarPerfil(perfil_registro));
	}
	@RequestMapping(value="/perfiles",method=RequestMethod.GET)
	public ResponseEntity<List<Perfil>> allPerfiles(){
		return ResponseEntity.ok(perfilesService.allPerfiles());
	}
	@RequestMapping(value="/perfiles/{id}",method=RequestMethod.GET)
	public ResponseEntity<Optional<Perfil>> getPerfil(@PathVariable long id){
		return ResponseEntity.ok(perfilesService.perfilPorId(id));
	}
	@RequestMapping(value="/perfiles/delete/{id}", method=RequestMethod.DELETE)
	public void deletePerfil(@PathVariable Long id){
		perfilDAO.deleteById(id);
	}
	@RequestMapping(value="/perfiles/editar",method=RequestMethod.POST)
	public ResponseEntity<Perfil> editarPerfil(@RequestBody Perfil perfil_editado){
		return ResponseEntity.ok(perfilesService.editarPerfil(perfil_editado));
	}
	@RequestMapping(value="/servicios",method=RequestMethod.GET)
	public ResponseEntity<List<Servicio>> getAllServicios(){
		return ResponseEntity.ok(serviciosService.allServicios());
	}
	@RequestMapping(value="/servicios/{id_servicio}", method=RequestMethod.GET)
	public ResponseEntity<Optional<Servicio>> PeticionServicios(@PathVariable long id_servicio){
		return ResponseEntity.ok(serviciosService.servicioPorId(id_servicio));
	}
	@RequestMapping(value="/servicios/profesional/{id_profesional}",method=RequestMethod.GET)
	public ResponseEntity<List<Servicio>> servicioPorId_profesional(@PathVariable long id_profesional){
		return ResponseEntity.ok(serviciosService.serviciosPorId_profesional(id_profesional));
	}
	@RequestMapping(value="/servicios/delete/{id_servicio}",method=RequestMethod.DELETE)
	public void eliminarServicio(@PathVariable long id_servicio){
		servicioDAO.deleteById(id_servicio);
	}
	@RequestMapping(value="/servicios/registrar",method=RequestMethod.POST)
	public ResponseEntity<Servicio> registrarServicio(@RequestBody Servicio servicio_registrado){
		return ResponseEntity.ok(serviciosService.registrarServicio(servicio_registrado));
	}
	@RequestMapping(value="/servicios/editar",method=RequestMethod.POST)
	public ResponseEntity<Servicio> editarServicio(@RequestBody Servicio servicio_editado){
		return ResponseEntity.ok(serviciosService.editarServicio(servicio_editado));
	}
	@RequestMapping(value="/clientes",method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> getClientes(){
		return ResponseEntity.ok(clientesService.allClientes());
	}
	@RequestMapping(value="/clientes/{id_cita}",method=RequestMethod.POST)
	public ResponseEntity<Optional<Cliente>> clientePorId(@PathVariable long id_cita){
		return ResponseEntity.ok(clientesService.clientePorId_cita(id_cita));
	}
	@RequestMapping(value="/clientes/servicio/{id_servicio}",method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> clientesPorId_servicio(@PathVariable long id_servicio){
		return ResponseEntity.ok(clientesService.clientesPorId_servicio(id_servicio));
	}
	@RequestMapping(value="/clientes/profesional/{id_profesional}",method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> clientesPorId_profesional(@PathVariable long id_profesional){
		return ResponseEntity.ok(clientesService.clientesPorId_profesional(id_profesional));
	}
	@RequestMapping(value="/servicios/buscar/{Keyword}", method=RequestMethod.GET)
	public ResponseEntity<List<Servicio>> serviciosKeyword(@PathVariable String Keyword){
		return ResponseEntity.ok(serviciosService.serviciosKeyword(Keyword));
	}
}
