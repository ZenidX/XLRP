package xlrp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xlrp.dao.ServicioDAO;
import xlrp.entities.Servicio;

@Service
public class ServiciosService {
	@Autowired
	ServicioDAO servicioDAO;
	
	public List<Servicio> allServicios(){
		return servicioDAO.findAll();
	}
	public Long countAll() {
		return servicioDAO.count();
	}
	public Servicio servicioPorId(long id_servicio) {
		List<Servicio>servicios =  servicioDAO.findAll();
		int i = 0;
		while(id_servicio != servicios.get(i).getId_servicio()) {
			i++;
			if(i==servicios.size()) {
				break;
			}
		}
		return servicios.get(i);
	}
	public Servicio servicioKeyword(String Keyword) {
		List<Servicio>serviciosKeyword = servicioDAO.findAll();
		int i = 0;
		while(Keyword != serviciosKeyword.get(i).getTitulo()) {
			i++;
			if(i==serviciosKeyword.size()) {
				break;
			}
		}
		return serviciosKeyword.get(i);
	}
}
