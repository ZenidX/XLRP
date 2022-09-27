package xlrp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xlrp.dao.*;
import xlrp.entities.*;

@Service
public class EntityService {
	@Autowired
	PerfilDAO perfilDAO;
	@Autowired
	ServicioDAO servicioDAO;
	@Autowired
	ClienteDAO clienteDAO;
	/////////////////////////////////////////////////////////////////AUTENTIFICACION
	public boolean autentificacion(Perfil perfil_sesion){
		boolean autentificacion=false;
		List<Perfil> perfiles=perfilDAO.findAll();
		int i=0;
		while(i!=perfiles.size()){
			if(perfil_sesion.getEmail().equals(perfiles.get(i).getEmail())) {
				if(perfil_sesion.getContraseña().equals(perfiles.get(i).getContraseña())) {
					autentificacion=true;
					break;
				}
			}
			i++;
		}
		return autentificacion;
	}
	/////////////////////////////////////////////////////////////////CONTAR TODAS LAS COSAS
	public Long countAllPerfiles(){
		return perfilDAO.count();
	}
	public Long countAllServicios() {
		return servicioDAO.count();
	}
	public Long countAllClientes() {
		return clienteDAO.count();
	}
	/////////////////////////////////////////////////////////////////OBTENER TODAS LAS COSAS
	public List<Perfil> allPerfiles(){
		return perfilDAO.findAll();
	}
	public List<Servicio> allServicios(){
		return servicioDAO.findAll();
	}
	public List<Cliente> allClientes(){
		return clienteDAO.findAll();
	}
	/////////////////////////////////////////////////////////////////OBTENER COSAS BUSCANDO
	public List<Servicio> serviciosKeyword(String Keyword) {
		List<Servicio> servicios=servicioDAO.findAll();
		List<Servicio> servicios_encontrados=new ArrayList<Servicio>();
		int i = 0;
		while(i!=servicios.size()){
			if(servicios.get(i).getTitulo().contains(Keyword)){
				servicios_encontrados.add(servicios.get(i));
			}
			i++;
		}
		return servicios_encontrados;
	}
	/////////////////////////////////////////////////////////////////OBTENER COSAS POR ID FACIL
	public Optional<Perfil> perfilPorId(long id) {;
		return perfilDAO.findById(id);
	}
	public Optional<Servicio> servicioPorId_servicio(long id_servicio) {
		return servicioDAO.findById(id_servicio);
	}
	public Optional<Cliente> clientePorId_cita(long id_cita) {
		return clienteDAO.findById(id_cita);
	}
	public List<Servicio> serviciosPorId_profesional(long id_profesional){
		List<Servicio> all_servicios=servicioDAO.findAll();
		List<Servicio> servicios_profesional=new ArrayList<Servicio>();
		for(int i=0;i<all_servicios.size();i++){
			if(all_servicios.get(i).getId_profesional()==id_profesional){
				servicios_profesional.add(all_servicios.get(i));
			}
		}
		return servicios_profesional;
	}
	public List<Cliente> clientesPorId_servicio(long id_servicio){
		List<Cliente> clientes=clienteDAO.findAll();
		List<Cliente> clientes_servicio=new ArrayList<Cliente>();
		int i=0;
		while(i!=clientes.size()) {
			if(id_servicio==clientes.get(i).getId_servicio()){
				clientes_servicio.add(clientes.get(i));
			}
			i++;
		}
		return clientes_servicio;
	}
	/////////////////////////////////////////////////////////////////OBTENER COSAS POR ID DEL ABUELO
	public List<Cliente> clientesPorId_profesional(long id_profesional){
		List<Servicio> servicios_profesional=serviciosPorId_profesional(id_profesional);
		List<Cliente> clientes_profesional=new ArrayList<Cliente>();
		for(int i=0;i<servicios_profesional.size();i++){
			clientes_profesional.addAll(clientesPorId_servicio(servicios_profesional.get(i).getId_servicio()));
		}
		return clientes_profesional;
	}
	/////////////////////////////////////////////////////////////////REGISTRAR COSAS
	public Perfil registrarPerfil(Perfil perfil_registro){
		perfilDAO.save(perfil_registro);
		List<Perfil> perfiles=perfilDAO.findAll();
		int i=0;
		while(i!=perfiles.size()){
			if(perfil_registro.getEmail()==perfiles.get(i).getEmail()) {
				if(perfil_registro.getContraseña()==perfiles.get(i).getContraseña()) {
					break;
				}
			}
			i++;
		}
		return perfiles.get(i);
	}
	public Servicio registrarServicio(Servicio servicio_registrado){
		servicioDAO.save(servicio_registrado);
		List<Servicio> servicios=servicioDAO.findAll();
		int i=0;
		while(i!=servicios.size()) {
			if(servicio_registrado.getId_profesional()==servicios.get(i).getId_profesional()){
				if(servicio_registrado.getTitulo()==servicios.get(i).getTitulo()){
					break;
				}
			}
			i++;
		}
		return servicios.get(i); 
	}
	/////////////////////////////////////////////////////////////////EDITAR COSAS
	public Servicio editarServicio(Servicio servicio_editado) {
		servicioDAO.save(servicio_editado);
		return servicioDAO.getReferenceById(servicio_editado.getId_servicio());
	}
	public Optional<Perfil> editarPerfil(Perfil perfil_editado) {
		perfilDAO.save(perfil_editado);
		return perfilDAO.findById(perfil_editado.getId());
	}
	/////////////////////////////////////////////////////////////////ELIMINAR COSAS
	public void eliminarPorId_cita(long id_cita) {
		clienteDAO.deleteById(id_cita);
	}
	public void eliminarPorId_servicio(long id_servicio){
		List<Cliente> clientes_servicio =clientesPorId_servicio(id_servicio);
		for(int i=0;i<clientes_servicio.size();i++){
			eliminarPorId_cita(clientes_servicio.get(i).getId_cita());
		}
		servicioDAO.deleteById(id_servicio);
	}
	public void eliminarPerfilPorId(long id){
		List<Servicio> servicios_profesional=serviciosPorId_profesional(id);
		for(int i=0;i<servicios_profesional.size();i++) {
			eliminarPorId_servicio(servicios_profesional.get(i).getId_servicio());
		}
		perfilDAO.deleteById(id);
	}
}
