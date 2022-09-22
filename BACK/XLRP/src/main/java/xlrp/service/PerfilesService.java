package xlrp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import xlrp.XLRPApplication;
import xlrp.dao.PerfilDAO;
import xlrp.entities.Perfil;


@Service
public class PerfilesService {
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(XLRPApplication.class);
	@Autowired
	PerfilDAO perfilDAO;
	public boolean autentificacion(Perfil perfil_sesion){
		String cuenta     = perfil_sesion.getCuenta();
		String contraseña = perfil_sesion.getCuenta();
		boolean autentification=false;
		List<Perfil> perfiles=perfilDAO.findAll();
		for(int i=0;i<perfiles.size();i++){
			if(cuenta==(perfiles.get(i)).getCuenta()){
				if(contraseña==(perfiles.get(i)).getContraseña()){
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
	public Long countAll(){
		return perfilDAO.count();
	}
	public Perfil registro(Perfil perfil_registro){

		//LOGGER.info(perfil_registro.toString());
		return perfil_registro;
		/*
		perfilDAO.saveAndFlush(perfil_registro);
		List<Perfil> perfiles=perfilDAO.findAll();
		int i=0;
		while(i<perfiles.size()){
			if(perfil_registro.getCuenta()==perfiles.get(i).getCuenta()){
				if(perfil_registro.getContraseña()==perfiles.get(i).getContraseña()) {
					break;
				}
			}
			i++;
		}
		return perfiles.get(i);
		*/
	}
}
