package xlrp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio{
	@Id
	@Column(name="id_servicio")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_servicio;
	@Column(name="id_profesional")
	private long id_profesional;
	@Column(name="foto")
	private byte[] foto;
	@Column(name="titular")
	private String titular;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="horario")
	private String horario;
	@Column(name="tarifa")
	private String tarifa;
	public Servicio(){}
	public Servicio(
			byte[] foto,
			String titulo,
			String descripcion,
			String horario,
			String tarifa
			){
		this.foto=foto;
		this.titular=titulo;
		this.descripcion=descripcion;
		this.horario=horario;
		this.tarifa=tarifa;
	}
	public long getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(long id_servicio) {
		this.id_servicio = id_servicio;
	}
	public long getId_profesional() {
		return this.id_profesional;
	}
	public void setId_profesional(long id_profesional) {
		this.id_profesional=id_profesional;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitulo(String titular) {
		this.titular = titular;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getTarifa() {
		return tarifa;
	}
	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}
}
