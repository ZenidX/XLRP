package xlrp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xlrp.dao.*;
import xlrp.entities.*;



@Service
public class PerfilesService {
	@Autowired
	PerfilDAO perfilDAO;
	@Autowired
	ServicioDAO servicioDAO;
	@Autowired
	ServiciosService serviciosService;
	@Autowired
	ClienteDAO clienteDAO;
	@Autowired
	ClientesService clientesService;
	public boolean autentificacion(Perfil perfil_sesion){
		boolean autentification=false;
		List<Perfil> perfiles=perfilDAO.findAll();
		int i=0;
		while(i!=perfiles.size()){
			if(perfil_sesion.getEmail()==perfiles.get(i).getEmail()) {
				if(perfil_sesion.getContraseña()==perfiles.get(i).getContraseña()) {
					autentification = true;
					break;
				}
			}
			i++;
		}
		return autentification;
	}
	public List<Perfil> allPerfiles(){
		List<Perfil> perfiles=perfilDAO.findAll();
		return perfiles;
	}
	public Optional<Perfil> perfilPorId(long id) {;
		return perfilDAO.findById(id);
	}
	public Long countAll(){
		return perfilDAO.count();
	}
	public Perfil registrarPerfil(Perfil perfil_registro){
		perfilDAO.save(perfil_registro);
		List<Perfil> perfiles=perfilDAO.findAll();
		int i=0;
		while(i!=perfiles.size()){
			if(perfil_registro.getEmail()==perfiles.get(i).getEmail()) {
				if(perfil_registro.getContraseña()==perfiles.get(i).getContraseña()) {
					break;
				}
			}
			i++;
		}
		return perfiles.get(i);
	}
	public Optional<Perfil> editarPerfil(Perfil perfil_editado) {
		perfilDAO.save(perfil_editado);
		return perfilDAO.findById(perfil_editado.getId());
	}
	public void eliminarPorId(long id){
		List<Cliente> clientes_profesional  = clientesService.clientesPorId_profesional(id);
		for(int i=0;i<clientes_profesional.size();i++){
			clienteDAO.deleteById(clientes_profesional.get(i).getId_cita());
		}
		List<Servicio> servicios_profesional = serviciosService.serviciosPorId_profesional(id);
		for(int i=0;i<servicios_profesional.size();i++) {
			servicioDAO.deleteById(servicios_profesional.get(i).getId_servicio());
		}
		perfilDAO.deleteById(id);
	}
}
