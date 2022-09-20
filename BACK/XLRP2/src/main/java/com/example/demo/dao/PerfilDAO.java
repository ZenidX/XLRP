package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Perfil;


@Repository
public interface PerfilDAO extends JpaRepository<Perfil,Long>{

}
