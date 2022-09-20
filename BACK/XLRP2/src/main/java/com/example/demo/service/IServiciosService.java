package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Servicio;

public interface IServiciosService {
	Long countAll();
	List<Servicio> allServicios();
}
