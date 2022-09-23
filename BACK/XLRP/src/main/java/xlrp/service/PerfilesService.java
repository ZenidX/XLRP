package xlrp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xlrp.dao.PerfilDAO;
import xlrp.entities.Perfil;


@Service
public class PerfilesService {
	@Autowired
	PerfilDAO perfilDAO;
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
	public Perfil perfilPorId(long id) {;
		return perfilDAO.getReferenceById(id);
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
	public Perfil editarPerfil(Perfil perfil_editado) {
		perfilDAO.save(perfil_editado);
		return perfilDAO.getReferenceById(perfil_editado.getId());
	}
}
