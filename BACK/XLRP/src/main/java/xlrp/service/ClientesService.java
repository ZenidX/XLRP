package xlrp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xlrp.dao.ClienteDAO;
import xlrp.entities.Cliente;

@Service
public class ClientesService {
	@Autowired
	ClienteDAO clienteDAO;
	public List<Cliente> allClientes(){
		return clienteDAO.findAll();
	}
	public Long countAll() {
		return clienteDAO.count();
	}
}
