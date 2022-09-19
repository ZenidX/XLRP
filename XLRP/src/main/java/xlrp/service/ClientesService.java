package xlrp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xlrp.entities.Cliente;
import xlrp.dao.ClienteDAO;

@Service
public class ClientesService {
	@Autowired
	ClienteDAO clienteDAO;
	public List<Cliente> allclientes(){
		return clienteDAO.findAll();
	}
	public Long countAll() {
		return clienteDAO.count();
	}
}
