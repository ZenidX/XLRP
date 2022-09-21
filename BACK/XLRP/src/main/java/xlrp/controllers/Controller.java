package xlrp.controllers;

import java.util.List;

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
	@RequestMapping(value="/perfiles",method=RequestMethod.GET)
	public ResponseEntity<List<Perfil>> getPerfiles(){
		List<Perfil> perfiles = perfilesService.allPerfiles();
		return ResponseEntity.ok(perfiles);
	}
	@RequestMapping(value="/servicios",method=RequestMethod.GET)
	public ResponseEntity<List<Servicio>> getAllServicios(){
		List<Servicio> servicios=serviciosService.allServicios();
		return ResponseEntity.ok(servicios);
	}
	@RequestMapping(value="/servicios/1",method=RequestMethod.GET)
	public ResponseEntity<Servicio> getServicio(){
		Servicio serv1=serviciosService.getUno();
		return ResponseEntity.ok(serv1);
	}
	@RequestMapping(value="{id_servicio}",method=RequestMethod.GET)
	public ResponseEntity<Void> deleteServicio(@PathVariable("id_servicio") Long id_servicio){
		servicioDAO.deleteById(id_servicio);
		return ResponseEntity.ok(null);
	}
	@RequestMapping(value="/perfiles/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePerfil(@PathVariable Long id){
		perfilDAO.deleteById(id);
		return ResponseEntity.ok(null);
	}
}