package xlrp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xlrp.entities.Servicio;


@Repository
public interface ServicioDAO extends JpaRepository<Servicio,Long>{

}
