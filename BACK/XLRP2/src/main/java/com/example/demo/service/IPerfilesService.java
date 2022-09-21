package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Perfil;

public interface IPerfilesService {
	Long countAll();
	List<Perfil> allPerfiles();
}
