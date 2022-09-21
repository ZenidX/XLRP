package xlrp.service;

import java.util.List;
import xlrp.entities.Servicio;

public interface IServiciosService {
	Long countAll();
	List<Servicio> allServicios();
}
