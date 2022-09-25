package xlrp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public Optional<Servicio> servicioPorId(long id_servicio) {
		return servicioDAO.findById(id_servicio);
	}
	public List<Servicio> serviciosPorId_profesional(long id_profesional){
		List<Servicio> all_servicios=servicioDAO.findAll();
		List<Servicio> servicios_profesional=new ArrayList<Servicio>();
		for(int i=0;i<all_servicios.size();i++){
			if(all_servicios.get(i).getId_profesional()==id_profesional){
				servicios_profesional.add(all_servicios.get(i));
			}
		}
		return servicios_profesional;
	}
	public Servicio registrarServicio(Servicio servicio_registrado){
		servicioDAO.save(servicio_registrado);
		List<Servicio> servicios=servicioDAO.findAll();
		int i=0;
		while(i!=servicios.size()) {
			if(servicio_registrado.getId_profesional()==servicios.get(i).getId_profesional()){
				if(servicio_registrado.getTitulo()==servicios.get(i).getTitulo()){
					break;
				}
			}
			i++;
		}
		return servicios.get(i); 
	}
	public Servicio editarServicio(Servicio servicio_editado) {
		servicioDAO.save(servicio_editado);
		return servicioDAO.getReferenceById(servicio_editado.getId_servicio());
	}
	public List<Servicio> serviciosKeyword(String Keyword) {
		List<Servicio> servicios=servicioDAO.findAll();
		List<Servicio> servicios_encontrados=new ArrayList<Servicio>();
		int i = 0;
		while(i!=servicios.size()){
			if(servicios.get(i).getTitulo().contains(Keyword)){
				servicios_encontrados.add(servicios.get(i));
			}
			i++;
		}
		return servicios_encontrados;
	}
}
