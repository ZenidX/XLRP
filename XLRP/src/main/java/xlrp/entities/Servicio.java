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
	@Column(name="foto")
	private String foto;
	@Column(name="titulo")
	private String titulo;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="horario")
	private String horario;
	@Column(name="tarifa")
	private String tarifa;
	public Servicio(){}
	public Servicio(
			String foto,
			String titulo,
			String descripcion,
			String horario,
			String tarifa
			){
		this.foto=foto;
		this.titulo=titulo;
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
