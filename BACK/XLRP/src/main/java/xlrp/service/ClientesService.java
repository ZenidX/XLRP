package xlrp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	@Autowired
	
	public List<Cliente> allClientes(){
		return clienteDAO.findAll();
	}
	public Long countAll() {
		return clienteDAO.count();
	}
	public Optional<Cliente> clientePorId_cita(long id_cita) {
		return clienteDAO.findById(id_cita);
	}
	public List<Cliente> clientesPorId_servicio(long id_servicio){
		List<Cliente> clientes=clienteDAO.findAll();
		List<Cliente> clientes_servicio=new ArrayList<Cliente>();
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
		List<Cliente> clientes_profesional=new ArrayList<Cliente>();
		for(int i=0;i<servicios_profesional.size();i++){
			clientes_profesional.addAll(clientesPorId_servicio(servicios_profesional.get(i).getId_servicio()));
		}
		return clientes_profesional;
	}
	public void eliminarPorId_cita(long id_cita) {
		clienteDAO.deleteById(id_cita);
	}
}
