package project.login;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {
		
		
	  @Id
	  @Column(unique=true)
	  private String correoElectronico;
	  
		@Column
	    private String nombreUsuario;
		
		
		@Column
	    private String contrasenya;


		public String getCorreoElectronico() {
			return correoElectronico;
		}


		public void setCorreoElectronico(String correoElectronico) {
			this.correoElectronico = correoElectronico;
		}


		public String getNombreUsuario() {
			return nombreUsuario;
		}


		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}


		public String getContrasenya() {
			return contrasenya;
		}


		public void setContrasenya(String contrasenya) {
			this.contrasenya = contrasenya;
		}
	    
	    // Getters y setters
	  

	}
