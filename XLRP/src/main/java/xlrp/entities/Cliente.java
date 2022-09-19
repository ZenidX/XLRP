package xlrp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@Column(name="id_cita")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_cita;
	private long id_cliente;
	private long id_servicio;
	private String hora;
	private String direccion;
	private String municipio;
	private String cp;
	private String comentarios;
	public Cliente(){}
	public Cliente(long id_cita, long id_cliente, long id_servicio, String hora, String direccion, String municipio,
			String cp, String comentarios) {
		super();
		this.id_cita = id_cita;
		this.id_cliente = id_cliente;
		this.id_servicio = id_servicio;
		this.hora = hora;
		this.direccion = direccion;
		this.municipio = municipio;
		this.cp = cp;
		this.comentarios = comentarios;
	}
	public long getId_cita() {
		return id_cita;
	}
	public void setId_cita(long id_cita) {
		this.id_cita = id_cita;
	}
	public long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public long getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(long id_servicio) {
		this.id_servicio = id_servicio;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}
