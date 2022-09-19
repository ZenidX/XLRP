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
	
}
