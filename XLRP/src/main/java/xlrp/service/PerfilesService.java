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
		return perfilDAO.findAll();
	}
	public Long countAll() {
		return perfilDAO.count();
	}
}
