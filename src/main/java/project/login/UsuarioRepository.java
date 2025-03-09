package project.login;

import org.springframework.data.jpa.repository.JpaRepository;





public interface UsuarioRepository extends JpaRepository<Usuario, String>{


	Usuario findByCorreoElectronico(String correoElectronico);
	
}
