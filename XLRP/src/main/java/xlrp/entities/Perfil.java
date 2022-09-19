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
	@Column(name="cuenta")
	private String cuenta;
	@Column(name="contraseña")
	private String contraseña;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="titulo")
	private String titulo;
	@Column(name="direccion")
	private String direccion;
	@Column(name="municipio")
	private String municipio;
	@Column(name="cp")
	private String cp;
	@Column(name="telefono")
	private String telefono;
	@Column(name="email")
	private String email;
	@Column(name="foto")
	private String foto;
	public Perfil(){}
	public Perfil(String cuenta,String password,String nombre,String apellidos,String titulo,String direccion,String municipio,String cp,String telefono,String email,String foto){
		this.cuenta=cuenta;
		this.contraseña=password;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.titulo=titulo;
		this.direccion=direccion;
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
	public void setCuenta(String cuenta) {
		this.cuenta=cuenta;
	}
	public String getCuenta() {
		return this.cuenta;
	}
	public void setPassword(String contraseña) {
		this.contraseña=contraseña;
	}
	public String getPassword() {
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
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
}
