package xlrp.service;

import java.util.List;
import xlrp.entities.Perfil;

public interface IPerfilesService {
	Long countAll();
	List<Perfil> allPerfiles();
}
