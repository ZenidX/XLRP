package xlrp.service;

import java.util.List;
import xlrp.entities.Cliente;

public interface IClientesService {
	Long countAll();
	List<Cliente> allClientes();
}
