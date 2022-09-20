package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClienteDAO;
import com.example.demo.entities.Cliente;


@Service
public class ClientesService {
	@Autowired
	ClienteDAO clienteDAO;
	public List<Cliente> allclientes(){
		return clienteDAO.findAll();
	}
	public Long countAll() {
		return clienteDAO.count();
	}
}
