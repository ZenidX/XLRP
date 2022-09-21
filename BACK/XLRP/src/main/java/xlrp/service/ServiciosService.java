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
	public Servicio getUno() {
		return servicioDAO.getReferenceById((long)1);
	}
}
