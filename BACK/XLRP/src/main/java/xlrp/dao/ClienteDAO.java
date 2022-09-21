package xlrp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xlrp.entities.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente,Long>{

}
