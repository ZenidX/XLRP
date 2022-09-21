package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PerfilDAO;
import com.example.demo.dao.ServicioDAO;
import com.example.demo.entities.Perfil;
import com.example.demo.entities.Servicio;
import com.example.demo.service.PerfilesService;
import com.example.demo.service.ServiciosService;

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
	@GetMapping(value="/perfiles")
	public ResponseEntity<List<Perfil>> getPerfiles(){
		List<Perfil> perfiles = perfilesService.allPerfiles();
		return ResponseEntity.ok(perfiles);
	}
	@GetMapping(value="{id}")
	public ResponseEntity<Void> deletePerfil(@PathVariable("id") Long id){
		perfilDAO.deleteById(id);
		return ResponseEntity.ok(null);
	}
	@RequestMapping(value="/autentificacion",method=RequestMethod.POST)
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
	@RequestMapping(value="/servicios",method=RequestMethod.GET)
	public ResponseEntity<List<Servicio>> getServicios(){
		List<Servicio> servicios=serviciosService.allServicios();
		return ResponseEntity.ok(servicios);
	}
	@RequestMapping(value="/servicios/1",method=RequestMethod.GET)
	public ResponseEntity<Servicio> getServicio(){
		Servicio serv1=serviciosService.getUno();
		return ResponseEntity.ok(serv1);
	}
	@GetMapping(value="{id_servicio}")
	public ResponseEntity<Void> readServicio(@PathVariable("id_servicio") Long id_servicio){
		servicioDAO.deleteById(id_servicio);
		return ResponseEntity.ok(null);
	}
}
