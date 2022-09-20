package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Servicio;


@Repository
public interface ServicioDAO extends JpaRepository<Servicio,Long>{

}
