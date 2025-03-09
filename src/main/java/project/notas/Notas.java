package project.notas;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import project.multimedia.Multimedia;

@Entity
public class Notas {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String titulo;
	private String campanya;
	private String descripcion;
	private String categoria;
	private String dia;
	private int sesiones;
	private Time hora;
	private String subcategoria;
	private Multimedia icono;
	
	//getters y setters
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCampanya() {
		return campanya;
	}
	public void setCampanya(String campanya) {
		this.campanya = campanya;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public int getSesiones() {
		return sesiones;
	}
	public void setSesiones(int sesiones) {
		this.sesiones = sesiones;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getSubcategoria() {
		return subcategoria;
	}
	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}
	public Multimedia getIcono() {
		return icono;
	}
	public void setIcono(Multimedia icono) {
		this.icono = icono;
	}
	
	
}
