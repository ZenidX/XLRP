package xlrp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import xlrp.dao.*;
import xlrp.entities.*;
import xlrp.service.*;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	private PerfilDAO perfilDAO;
	@Autowired
	private PerfilesService perfilesService;
	@RequestMapping(value="/perfiles",method=RequestMethod.GET)
	public ResponseEntity<List<Perfil>> getPerfiles(){
		List<Perfil> perfiles = perfilesService.allPerfiles();
		return ResponseEntity.ok(perfiles);
	}
	@GetMapping(value="/Perfiles/delete={id}")
	public ResponseEntity<Void> deletePerfil(@PathVariable("id") Long id){
		perfilDAO.deleteById(id);
		return ResponseEntity.ok(null);
	}
	@RequestMapping(value="/autenticacion",method=RequestMethod.POST)
	public boolean iniciarSesion(@RequestBody Perfil perfil_sesion){
		String cuenta     = perfil_sesion.getCuenta();
		String contraseña = perfil_sesion.getCuenta();
		boolean autentification=false;
		List<Perfil> perfiles=perfilDAO.findAll();
		for(int i=0;i<perfiles.size();i++){
			if(cuenta==(perfiles.get(i)).getCuenta()){
				if(contraseña==(perfiles.get(i)).getPassword()){
					autentification=true;
				}
			}
		}
		return autentification;
	}
	@Autowired
	private ServicioDAO servicioDAO;
	@Autowired
	private ServiciosService serviciosService;
	@RequestMapping(value="/servicios",method=RequestMethod.GET)
	public ResponseEntity<List<Servicio>> getServicios(){
		List<Servicio> servicios=serviciosService.allServicios();
		return ResponseEntity.ok(servicios);
	}
	@GetMapping(value="{id_servicio}")
	public ResponseEntity<Void> deleteServicio(@PathVariable("id_servicio") Long id_servicio){
		servicioDAO.deleteById(id_servicio);
		return ResponseEntity.ok(null);
	}
}