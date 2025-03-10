package project.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

	
	 @Autowired
	    private UsuarioService usuarioService;
	 
	 //CREAR USUARIOS
    @PostMapping(value = "/crearUsuario", consumes = "application/x-www-form-urlencoded")
	    
	    public ResponseEntity<String> crearUsuario(@RequestParam String correo,@RequestParam String usuario, @RequestParam String contrasenya, @RequestParam String contrasenya2) {
	    
    		if(contrasenya.equals(contrasenya2)) {
	    		    	
	    	try { 
		        return new ResponseEntity<String>(usuarioService.guardarUsuario(usuario, correo, contrasenya).getNombreUsuario()+"Usuario creado con éxito",HttpStatus.OK); 
	    	}
	    	catch(DataIntegrityViolationException e) {
	    		return new ResponseEntity<String>("Ese correo ya ha sido utilizado.",HttpStatus.BAD_REQUEST);
	    	}
    	}
    		else {
    			return new ResponseEntity<String>("Las dos contraseñas no coinciden.",HttpStatus.BAD_REQUEST);
    		}
    }
    
    //INICIAR SESION
    @GetMapping(value = "/comprobarContrasenya")
    public ResponseEntity<String> comprobarContrasenya(@RequestParam String correo, @RequestParam String contrasenya) {
    	System.out.println("usando metodo verificar");
        boolean correcto = usuarioService.comprobarContrasenya(correo, contrasenya);
        if (correcto) {
            return new ResponseEntity<String>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Clave incorrecta", HttpStatus.BAD_REQUEST);
        }
    }
}