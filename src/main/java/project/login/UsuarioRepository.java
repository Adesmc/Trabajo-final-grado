package project.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, String>{


	Usuario findByCorreoElectronico(String correoElectronico);
	
}
