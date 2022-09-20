package xlrp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xlrp.entities.Perfil;
import xlrp.dao.PerfilDAO;

@Service
public class PerfilesService {
	@Autowired
	PerfilDAO perfilDAO;
	public List<Perfil> allPerfiles(){
		List<Perfil> perfiles=perfilDAO.findAll();
		return perfiles;
	}
	public Long countAll() {
		return perfilDAO.count();
	}
}
