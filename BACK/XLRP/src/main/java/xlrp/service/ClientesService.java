package xlrp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xlrp.dao.ClienteDAO;
import xlrp.entities.Cliente;
import xlrp.entities.Servicio;

@Service
public class ClientesService {
	@Autowired
	ClienteDAO clienteDAO;
	@Autowired
	ServiciosService servicioService;
	public List<Cliente> allClientes(){
		return clienteDAO.findAll();
	}
	public Long countAll() {
		return clienteDAO.count();
	}
	public Cliente clientePorId_cita(long id_cita) {
		return clienteDAO.getReferenceById(id_cita);
	}
	public List<Cliente> clientesPorId_servicio(long id_servicio){
		List<Cliente> clientes=clienteDAO.findAll();
		List<Cliente> clientes_servicio=clientes;
		clientes_servicio.clear();
		int i=0;
		while(i!=clientes.size()) {
			if(id_servicio==clientes.get(i).getId_servicio()){
				clientes_servicio.add(clientes.get(i));
			}
			i++;
		}
		return clientes_servicio;
	}
	public List<Cliente> clientesPorId_profesional(long id_profesional){
		List<Servicio> servicios_profesional=servicioService.serviciosPorId_profesional(id_profesional);
		List<Cliente> clientes_profesional=clienteDAO.findAll();
		clientes_profesional.clear();
		for(int i=0;i<servicios_profesional.size();i++){
			clientes_profesional.addAll(clientesPorId_servicio(servicios_profesional.get(i).getId_servicio()));
		}
		return clientes_profesional;
	}
}
