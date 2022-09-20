package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Cliente;


public interface IClientesService {
	Long countAll();
	List<Cliente> allClientes();
}
