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
	
	//End Point de Inicio de Sesión.------------------------------------------------------------->
	@RequestMapping(value="/autentificacion",method=RequestMethod.POST)
	public boolean iniciarSesion(@RequestBody Perfil perfil_sesion){
		return perfilesService.autentificacion(perfil_sesion);
	}
	
	//End Point de Registro.--------------------------------------------------------------------->
	@RequestMapping(value="/registrarse",method=RequestMethod.POST)
	public ResponseEntity<Perfil> registrarse1(@RequestBody Perfil perfil_registro){
		return ResponseEntity.ok(perfilesService.registro(perfil_registro));
	}
	
	//End Point de Todos los Perfiles.----------------------------------------------------------->
	@RequestMapping(value="/perfiles",method=RequestMethod.GET)
	public ResponseEntity<List<Perfil>> getPerfiles(){
		List<Perfil> perfiles = perfilesService.allPerfiles();
		return ResponseEntity.ok(perfiles);
	}
	
	//End Point de Todos los Servicios.---------------------------------------------------------->
	@RequestMapping(value="/servicios",method=RequestMethod.GET)
	public ResponseEntity<List<Servicio>> getAllServicios(){
		List<Servicio> servicios=serviciosService.allServicios();
		return ResponseEntity.ok(servicios);
	}
	
	//End Point de Servicio por ID.-------------------------------------------------------------->
	@RequestMapping(value="/servicios/{id_servicio}", method=RequestMethod.GET)
	public ResponseEntity<Servicio> PeticionServicios(@PathVariable long id_servicio){
		return ResponseEntity.ok(serviciosService.servicioPorId(id_servicio));
	}
	
	//End Point de Borrado de Perfiles.----------------------------------------------------------->
	@RequestMapping(value="/perfiles/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePerfil(@PathVariable Long id){
		perfilDAO.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	//End Point de Buscador de Servicios por palabra clave.--------------------------------------->
	@RequestMapping(value="/Servicio/Buscar/{Keyword}", method=RequestMethod.GET)
	public ResponseEntity<Servicio> ServicioBuscador(@PathVariable String Keyword){
		return ResponseEntity.ok(serviciosService.servicioKeyword(Keyword));
		
	}
}
