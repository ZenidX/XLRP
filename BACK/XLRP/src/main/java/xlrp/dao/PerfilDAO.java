package xlrp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xlrp.entities.Perfil;


@Repository
public interface PerfilDAO extends JpaRepository<Perfil,Long>{

}
