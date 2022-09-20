package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ServicioDAO;
import com.example.demo.entities.Servicio;

@Service
public class ServiciosService {
	@Autowired
	ServicioDAO servicioDAO;
	
	public List<Servicio> allServicios(){
		return servicioDAO.findAll();
	}
	public Long countAll() {
		return servicioDAO.count();
	}
}
