package project.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;


public class UsuarioService {

	 @Autowired
	    private UsuarioRepository usuarioRepository;
	 
	  public Usuario guardarUsuario(String usuario, String correo, String contrasenya) throws DataIntegrityViolationException {
	        Usuario nuevoUsuario = new Usuario();
	        nuevoUsuario.setNombreUsuario(usuario);
	        nuevoUsuario.setCorreoElectronico(correo);
	        nuevoUsuario.setContrasenya(contrasenya);
	        return usuarioRepository.save(nuevoUsuario);  
	  }
	  
	  
	  
	  public Usuario obtenerPorCorreo(String correoElectronico) {
	        return usuarioRepository.findByCorreoElectronico(correoElectronico);
	    }
	  


		    // Método para cambiar el nombre de usuario
		    public boolean cambiarNombreUsuario(String correoElectronico, String contrasenya, String nuevoNombreUsuario) {
		        
		        if (!comprobarContrasenya(correoElectronico, contrasenya)) {
		            return false;
		        }
		        Usuario usuario = usuarioRepository.findByCorreoElectronico(correoElectronico);
		        
		        if (usuario != null) {
		            usuario.setNombreUsuario(nuevoNombreUsuario);
		            usuarioRepository.save(usuario);
		            return true;
		        } else {
		            return false;
		        }
		    }

		    
		    // Método para cambiar la contraseña
		    public boolean cambiarContrasenya(String correoElectronico, String contrasenyaActual, String nuevaContrasenya) {
		            if (!comprobarContrasenya(correoElectronico, contrasenyaActual)) {
		            return false;
		        }
		       Usuario usuario = usuarioRepository.findByCorreoElectronico(correoElectronico);
		        
		        if (usuario != null) {
		            usuario.setContrasenya(nuevaContrasenya);
		            usuarioRepository.save(usuario);
		            return true;
		        } else {
		            return false;
		        }
		    }
		    // Método para comprobar la contraseña 
		    public boolean comprobarContrasenya(String correoElectronico, String contrasenya) {
		        Usuario usuario = usuarioRepository.findByCorreoElectronico(correoElectronico);
		        return usuario != null && usuario.getContrasenya().equals(contrasenya);
		    }
	  
}
