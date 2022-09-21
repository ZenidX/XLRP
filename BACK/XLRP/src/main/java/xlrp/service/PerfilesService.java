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
	public List<Perfil> allPerfiles(){
		List<Perfil> perfiles=perfilDAO.findAll();
		return perfiles;
	}
	public Long countAll() {
		return perfilDAO.count();
	}
}
