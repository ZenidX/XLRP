package xlrp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="perfiles")
public class Perfil{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="contraseña")
	private String contraseña;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="edad")
	private long edad;
	@Column(name="titular")
	private String titular;
	@Column(name="municipio")
	private String municipio;
	@Column(name="cp")
	private String cp;
	@Column(name="telefono")
	private String telefono;
	@Column(name="email")
	private String email;
	@Column(name="foto")
	private byte[] foto;
	public Perfil(){}
	public Perfil(String password,
			String nombre,
			String apellidos,
			String titular,
			String municipio,
			String cp,
			String telefono,
			String email,
			byte[] foto){
		this.contraseña=password;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.titular=titular;
		this.municipio=municipio;
		this.cp=cp;
		this.telefono=telefono;
		this.email=email;
		this.foto=foto;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setContraseña(String contraseña) {
		this.contraseña=contraseña;
	}
	public String getContraseña() {
		return this.contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setEdad(long edad) {
		this.edad=edad;
	}
	public long getEdad() {
		return this.edad;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titulo) {
		this.titular = titulo;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
}
