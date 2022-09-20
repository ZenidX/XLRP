package xlrp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xlrp.entities.Servicio;
import xlrp.dao.ServicioDAO;

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
}
